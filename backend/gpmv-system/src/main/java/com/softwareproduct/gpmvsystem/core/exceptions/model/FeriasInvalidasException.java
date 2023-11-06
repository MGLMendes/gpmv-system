package com.softwareproduct.gpmvsystem.core.exceptions.model;

public class FeriasInvalidasException extends RuntimeException{

    private String message;

    public FeriasInvalidasException(String message) {
        super(message);
        this.message = message;
    }
}
