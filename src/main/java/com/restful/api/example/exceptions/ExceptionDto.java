package com.restful.api.example.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDto {
    private Integer code;
    private String message;
}
