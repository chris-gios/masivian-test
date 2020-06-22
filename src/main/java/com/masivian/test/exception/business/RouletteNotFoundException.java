package com.masivian.test.exception.business;

public class RouletteNotFoundException extends Exception {
    public RouletteNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
