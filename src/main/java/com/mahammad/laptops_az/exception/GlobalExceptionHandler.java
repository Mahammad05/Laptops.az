package com.mahammad.laptops_az.exception;

import com.mahammad.laptops_az.model.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle ApplicationException
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ServiceResponse<?>> handleApplicationException(ApplicationException exception) {
        return ResponseEntity.status(exception.getExceptionEnum().getStatus())
                .body(ServiceResponse.failure(exception.getExceptionEnum().getMessage()));
    }
}
