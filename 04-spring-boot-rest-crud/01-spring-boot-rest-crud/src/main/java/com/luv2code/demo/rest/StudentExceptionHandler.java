package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleNotFoundException(StudentNotFoundException exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exc){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setErrorMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
