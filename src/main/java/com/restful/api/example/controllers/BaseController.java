package com.restful.api.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.api.example.exceptions.ExceptionDto;
import com.restful.api.example.exceptions.InvalidLengthExceptionInner;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;

public abstract class BaseController {
    @ExceptionHandler(InvalidLengthExceptionInner.class)
    public ResponseEntity<?> handleInvalidLengthException(InvalidLengthExceptionInner exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        ExceptionDto.builder()
                                .code(1234)
                                .message(exception.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        ExceptionDto.builder()
                                .code(1234)
                                .message(exception.getMessage())
                                .build()
                );
    }
}
