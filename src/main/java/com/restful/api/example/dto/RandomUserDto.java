package com.restful.api.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RandomUserDto {
    @NotBlank
    private String id;
    @Size(min = 5)
    @Size(max = 40)
    private String firstName;
    @Size(min = 5)
    @Size(max = 40)
    private String lastName;
}
