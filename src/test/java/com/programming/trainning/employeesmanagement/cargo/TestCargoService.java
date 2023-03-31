package com.programming.trainning.employeesmanagement.cargo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestCargoService {

    private CargoService cargoService; // Target class that is been tested. It will receive the mocks.
    @Mock
    private CargoRepository repository;

    @BeforeEach
    public void init() {
        this.cargoService = new CargoServiceImpl(repository);
    }
    @Test
    public void shouldRegisterANewRole() {

        CargoRequest cargoRequest = new CargoRequest();
        cargoRequest.setDescription("my role");

        Mockito.when(repository.existsByDescription(cargoRequest.getDescription().toUpperCase())).thenReturn(false); // Mocking dependence behavior

        Cargo cargo = new Cargo(cargoRequest.getDescription().toUpperCase());
        // cargo.setId(1);
        Mockito.when(repository.save(Mockito.any(Cargo.class))).thenReturn(cargo);

        Cargo newRole = cargoService.cadastra(cargoRequest);

        Assertions.assertNotNull(newRole);
//        Assertions.assertNotNull(newRole.getId());
//        Assertions.assertTrue(newRole.getId() > 0);
        Assertions.assertEquals(cargoRequest.getDescription().toUpperCase(), newRole.getDescription());

        Mockito.verify(repository, Mockito.times(1)).existsByDescription(cargoRequest.getDescription().toUpperCase());
        Mockito.verify(repository, Mockito.times(1)).save(Mockito.any(Cargo.class));
    }

    @Test
    public void shouldThrowEntityAlreadyExistsExceptionWhenRoleAlreadyExists() {

        CargoRequest cargoRequest = new CargoRequest();
        cargoRequest.setDescription("my role");

        Mockito.when(repository.existsByDescription(cargoRequest.getDescription().toUpperCase())).thenReturn(true);

        Assertions.assertThrows(EntityAlreadyExistsException.class, () -> {
            cargoService.cadastra(cargoRequest);
        });

        Mockito.verify(repository, Mockito.times(1)).existsByDescription(cargoRequest.getDescription().toUpperCase());
        Mockito.verify(repository, Mockito.times(0)).save(Mockito.any(Cargo.class));
    }

}

