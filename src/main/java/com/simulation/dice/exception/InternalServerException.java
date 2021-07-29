package com.simulation.dice.exception;

public class InternalServerException extends RuntimeException {
    private String customMessage;

    public InternalServerException(String message) {
        this.customMessage = message;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}
