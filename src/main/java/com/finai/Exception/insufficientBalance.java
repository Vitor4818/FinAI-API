package com.finai.Exception;

public class insufficientBalance extends RuntimeException {
    public insufficientBalance(String message) {
        super(message);
    }
}
