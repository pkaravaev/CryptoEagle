package com.cryptoeagle.exception;

public class RssNewsNotFoundException extends AppException {

    public String url;

    public RssNewsNotFoundException(String url) {
        this.url = url;
    }
}
