package com.softwareproduct.gpmvsystem.core.exceptions.model;

public class ContratadoException extends RuntimeException{

    private String message;

    public ContratadoException(String message) {
        super(message);
        this.message = message;
    }
}
