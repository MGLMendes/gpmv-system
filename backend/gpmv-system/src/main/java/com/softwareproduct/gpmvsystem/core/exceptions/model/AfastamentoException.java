package com.softwareproduct.gpmvsystem.core.exceptions.model;

public class AfastamentoException extends RuntimeException {
    private String message;

    public AfastamentoException(String message) {
        super(message);
        this.message = message;
    }
}
