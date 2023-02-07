package com.programming.trainning.employeesmanagement.cargo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargoService {

    Logger logger = LoggerFactory.getLogger(CargoService.class);

    private final CargoRepository cargoRepository;

    @Autowired
    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public Cargo cadastra(CargoRequest cargoRequest) {
        logger.info("cadastrando um novo cargo com a descricao: {}", cargoRequest.getDescription());

        Cargo cargo = cargoRequest.toModel();

        boolean exists = cargoRepository.existsByDescription(cargo.getDescription());
        if (exists) {
            String mensagem = "Cargo com a descricao: " + cargo.getDescription() + " já existe. Verificar.";
            Integer code = 1;
            String entityName = "CARGO";
            throw new EntityAlreadyExistsException(mensagem, code, entityName);
        }

        cargo = cargoRepository.save(cargo);

        logger.info("cargo com a descricao: {} cadastrada com sucesso", cargoRequest.getDescription());

        return cargo;
    }
}
