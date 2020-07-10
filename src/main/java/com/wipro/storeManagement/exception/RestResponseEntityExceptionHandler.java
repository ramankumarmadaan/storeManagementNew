package com.wipro.storeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    private static ErrorError RUNTIME_MESSAGE = new ErrorError(new Error(
            "There is some issue with the request", HttpStatus.BAD_REQUEST));

    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<Object> handleRuntime(
            RuntimeException ex) {
        return new ResponseEntity<>(RUNTIME_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
