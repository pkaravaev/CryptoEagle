package com.cryptoeagle.exception;

public class UserNotFoundException extends AppException{

    private String name;

    public UserNotFoundException(String name){
        this.name = name;
    }

}
