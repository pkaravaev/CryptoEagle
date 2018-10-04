package com.cryptoeagle.exception;

public class UserValidationException extends AppException {

    private String message;

    public UserValidationException(String message){

        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
