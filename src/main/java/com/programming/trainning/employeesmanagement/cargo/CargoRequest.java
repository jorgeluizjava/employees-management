package com.programming.trainning.employeesmanagement.cargo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class CargoRequest {

    @NotBlank(message = "description is required 123")
    @JsonProperty(value = "description")
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{\"CargoRequest\":{"
                + "\"description\":\"" + description + "\""
                + "}}";
    }

    public Cargo toModel() {
        return new Cargo(description);
    }
}
