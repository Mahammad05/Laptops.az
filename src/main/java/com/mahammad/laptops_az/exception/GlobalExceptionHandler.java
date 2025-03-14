package com.mahammad.laptops_az.exception;

import com.mahammad.laptops_az.model.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle ProductNotFoundException
    @ExceptionHandler
    public ResponseEntity<ServiceResponse<String>> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ServiceResponse.failure(ex.getMessage()));
    }

    // Handle CategoryNotFoundException
    @ExceptionHandler
    public ResponseEntity<ServiceResponse<String>> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ServiceResponse.failure(ex.getMessage()));
    }

    // Handle Global Exceptions
    @ExceptionHandler
    public ResponseEntity<ServiceResponse<String>> handleGlobalException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ServiceResponse.failure("Server Error: " + ex.getMessage()));
    }
}
