package com.programming.trainning.employeesmanagement.cargo;

public class EntityAlreadyExistsException extends RuntimeException {

    private Integer code;
    private String entityName;

    public EntityAlreadyExistsException(String message, Integer code, String entityName) {
        super(message);
        this.code = code;
        this.entityName = entityName;
    }
}
