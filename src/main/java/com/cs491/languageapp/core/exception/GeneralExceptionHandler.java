package com.cs491.languageapp.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatus status,
                                                                  @NonNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(LevelNullException.class)
    public ResponseEntity<?> levelNullExceptionHandler(LevelNullException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OccupantDoesntExistException.class)
    public ResponseEntity<?> occupantDoesntExistExceptionHandler(OccupantDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OccupantSuccessDoesntCreateYet.class)
    public ResponseEntity<?> occupantSuccessDoesntCreateYetExceptionHandler(OccupantSuccessDoesntCreateYet exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TotalSuccessOfOccupantDoesntExistYetException.class)
    public ResponseEntity<?> totalSuccessOfOccupantDoesntExistYetExceptionHandler(TotalSuccessOfOccupantDoesntExistYetException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(WordDoesntExistException.class)
    public ResponseEntity<?> wordDoesntExistExceptionHandler(WordDoesntExistException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(WrongLevelSelectedException.class)
    public ResponseEntity<?> wrongLevelSelectedExceptionHandler(WrongLevelSelectedException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PasswordDoesntMatchEmailException.class)
    public ResponseEntity<?> passwordDoesntMatchEmailExceptionHandler(PasswordDoesntMatchEmailException exception)  {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}