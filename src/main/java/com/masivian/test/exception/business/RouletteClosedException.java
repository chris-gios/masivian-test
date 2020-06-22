package com.masivian.test.exception.business;

public class RouletteClosedException extends Exception {
    public RouletteClosedException(String errorMessage) {
        super(errorMessage);
    }
}
