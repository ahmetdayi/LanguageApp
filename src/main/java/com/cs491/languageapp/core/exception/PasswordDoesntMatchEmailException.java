package com.cs491.languageapp.core.exception;

public class PasswordDoesntMatchEmailException extends RuntimeException{
    public PasswordDoesntMatchEmailException(String message) {
        super(message);
    }
}
