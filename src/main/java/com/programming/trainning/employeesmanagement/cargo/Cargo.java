package com.programming.trainning.employeesmanagement.cargo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.StringUtils;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "description is required")
    @Column(name = "description")
    private String description;

    /**
     * frameworks only
     */
    @Deprecated
    public Cargo() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cargo(String description) {
        if (StringUtils.isEmpty(description)) {
            throw new IllegalStateException("descricao é obrigatório");
        }
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
