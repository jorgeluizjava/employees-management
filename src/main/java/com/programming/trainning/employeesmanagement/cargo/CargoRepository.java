package com.programming.trainning.employeesmanagement.cargo;

import org.springframework.data.jpa.repository.JpaRepository;

// Desafios que serão encontrados

// O que é um cargo igual?
// PROGRAMADOR
// Programador
// Como resolver este cenário?

// Olhar funcoes que removem espacos e que deixam como tudo maiusculo ou tudo minusculo.

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
