package com.tom.Exception;

public class CustomException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message;

    public CustomException(String message) {
        this.message = message;
    }
}
