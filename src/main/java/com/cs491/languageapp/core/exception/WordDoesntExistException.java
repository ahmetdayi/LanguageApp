package com.cs491.languageapp.core.exception;

public class WordDoesntExistException extends RuntimeException {
    public WordDoesntExistException(String message) {
        super (message);
    }
}
