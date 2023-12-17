package com.example.iprwc_app_backend.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String errorMessage){
        super(errorMessage);
    }

}
