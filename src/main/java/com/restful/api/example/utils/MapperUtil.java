package com.restful.api.example.utils;

import com.restful.api.example.dto.RandomUserDto;
import com.restful.api.example.models.RandomUserModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MapperUtil {
    public RandomUserModel convertRandomUserDtoToModel(RandomUserDto dto) {
        return RandomUserModel.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }

    public RandomUserDto convertRandomUserModelToDto(RandomUserModel model) {
        return RandomUserDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .build();
    }
}
