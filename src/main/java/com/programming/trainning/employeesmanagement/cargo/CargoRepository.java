package com.programming.trainning.employeesmanagement.cargo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    boolean existsByDescription(String description);
}
