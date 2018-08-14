package com.cryptoeagle.exception;

public class UserNotFoundException extends Exception {

    private String name;

    public UserNotFoundException(String name){
        this.name = name;
    }
}
