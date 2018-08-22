package com.cryptoeagle.exception;

public class SymbolNotFoundException extends AppException {

    private String symbol;

    public SymbolNotFoundException(String symbol) {
        this.symbol = symbol;
    }
}
