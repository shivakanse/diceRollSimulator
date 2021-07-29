package com.simulation.dice.exception;

public class InvalidInputException extends RuntimeException {
    private String customMessage;

    public InvalidInputException(String message) {
        this.customMessage = message;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
}
