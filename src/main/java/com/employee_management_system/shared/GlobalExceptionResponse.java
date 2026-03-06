package com.employee_management_system.shared;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionResponse {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GlobalResponse<?>> handelNoResourceException(NoResourceFoundException ex) {
        var errors = List.of(
           new ErrorItem("Resource is not found")
        ) ; 
        return new ResponseEntity<>(new GlobalResponse<>(errors) , HttpStatus.NOT_FOUND); 
    }

    @ExceptionHandler(CustomResponseException.class)
    public ResponseEntity<GlobalResponse<?>> handelCustomException(CustomResponseException ex) {
        var errors = List.of(
           new ErrorItem(ex.getMessage())
        ) ; 
        return new ResponseEntity<>(new GlobalResponse<>(errors) , HttpStatus.resolve(ex.getCode()));  
    }


    @ExceptionHandler(MethodArgumentNotValidException.class) 
    public ResponseEntity<GlobalResponse<?>> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult().getFieldErrors().stream()
            .map(e -> new ErrorItem(e.getField() + " " + e.getDefaultMessage())).toList();  
        return new ResponseEntity<>(new GlobalResponse<>(errors) , HttpStatus.BAD_REQUEST) ; 
    }
}
