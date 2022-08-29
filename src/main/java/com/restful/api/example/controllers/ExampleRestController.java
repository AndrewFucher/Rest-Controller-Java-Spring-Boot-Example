package com.restful.api.example.controllers;

import com.restful.api.example.dto.RandomUserDto;
import com.restful.api.example.exceptions.ExceptionDto;
import com.restful.api.example.exceptions.InnerValidationException;
import com.restful.api.example.models.RandomUserModel;
import com.restful.api.example.services.api.SomeService;
import com.restful.api.example.utils.MapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/example")
@RequiredArgsConstructor
public class ExampleRestController extends BaseController {
    private final SomeService someService;

    @GetMapping(path = "/get-random-user")
    public Mono<RandomUserDto> getRandomUser() {
        return Mono.just(MapperUtil.convertRandomUserModelToDto(someService.getRandomUser()));
    }

    @SneakyThrows
    @PostMapping(path = "/set-random-user")
    public ResponseEntity<?> setRandomUser(@RequestBody @Valid RandomUserDto randomUserDto) {
        someService.setRandomUser(MapperUtil.convertRandomUserDtoToModel(randomUserDto));

        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @PostMapping(path = "/raise-exception")
    public ResponseEntity<?> raiseException(@RequestBody @Valid RandomUserDto randomUserDto) {
        try {
            someService.setRandomUser(MapperUtil.convertRandomUserDtoToModel(randomUserDto));
        } catch (InnerValidationException e) {
            return ResponseEntity.badRequest().body(
                    objectMapper.writeValueAsString(
                            ExceptionDto.builder()
                                    .code(1234)
                                    .message(e.getMessage())
                                    .build()
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                    objectMapper.writeValueAsString(
                            ExceptionDto.builder()
                                    .code(-1)
                                    .message("Unknown Error")
                                    .build()
                    )
            );
        }
        return ResponseEntity.ok().build();
    }
}
