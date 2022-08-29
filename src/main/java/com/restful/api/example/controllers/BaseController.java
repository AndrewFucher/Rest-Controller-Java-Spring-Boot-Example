package com.restful.api.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.api.example.exceptions.ExceptionDto;
import com.restful.api.example.exceptions.InvalidLengthExceptionInner;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {
    protected final ObjectMapper objectMapper;
    public BaseController() {
        objectMapper = new ObjectMapper();
    }

    @SneakyThrows
    @ExceptionHandler(InvalidLengthExceptionInner.class)
    public ResponseEntity<?> handleInvalidLengthException(InvalidLengthExceptionInner exception) {
        return ResponseEntity
                .badRequest()
                .body(
                objectMapper.writeValueAsString(
                        ExceptionDto.builder()
                                .code(1234)
                                .message(exception.getMessage())
                                .build()
                )
        );
    }
}
