package com.brainacad.oop.testshapes;

//Lab 2.10.4

public class InvalidShapeStringException extends Exception {
    private String message;

    public InvalidShapeStringException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
