package com.programming.trainning.employeesmanagement.cargo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CargoResponse {

    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "description")
    private String description;

    /**
     * Frameworks only
     */
    @Deprecated
    public CargoResponse() {
    }

    public CargoResponse(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public CargoResponse(Cargo cargo) {
        if (cargo == null) {
            throw new IllegalStateException("cargo está nulo, verificar");
        }
        this.id = cargo.getId();
        this.description = cargo.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{\"CargoResponse\":{"
                + "\"id\":\"" + id + "\""
                + ", \"description\":\"" + description + "\""
                + "}}";
    }
}
