package com.programming.trainning.employeesmanagement.cargo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cargos")
public class CargoController {
    Logger logger = LoggerFactory.getLogger(CargoController.class);
    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<CargoResponse> cadastra(@Valid @RequestBody CargoRequest cargoRequest) {

        logger.info("request: {}", cargoRequest);

        Cargo cargo = cargoService.cadastra(cargoRequest);

        CargoResponse cargoResponse = new CargoResponse(cargo);

        logger.info("response: {}", cargoResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(cargoResponse);
    }

}
