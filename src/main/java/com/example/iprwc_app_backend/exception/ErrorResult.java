package com.example.iprwc_app_backend.exception;

public class ErrorResult {
    private final String errorMessage;

    public ErrorResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
