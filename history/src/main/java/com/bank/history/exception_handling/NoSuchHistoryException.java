package com.bank.history.exception_handling;

public class NoSuchHistoryException extends RuntimeException {
    public NoSuchHistoryException(String message) {
        super(message);
    }
}
