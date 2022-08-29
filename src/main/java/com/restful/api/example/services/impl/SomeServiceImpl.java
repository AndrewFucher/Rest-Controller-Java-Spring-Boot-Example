package com.restful.api.example.services.impl;

import com.restful.api.example.exceptions.InvalidLengthExceptionInner;
import com.restful.api.example.models.RandomUserModel;
import com.restful.api.example.services.api.SomeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SomeServiceImpl implements SomeService {
    @Override
    public RandomUserModel getRandomUser() {
        return RandomUserModel.builder()
                .id(UUID.randomUUID().toString())
                .firstName(RandomStringUtils.randomAlphabetic(5, 18))
                .lastName(RandomStringUtils.randomAlphabetic(5, 18))
                .build();
    }

    @Override
    public void setRandomUser(RandomUserModel randomUser) throws Exception {
        if (randomUser.getFirstName().length() == 5) {
            throw new InvalidLengthExceptionInner("Invalid first name length");
        } else if (randomUser.getFirstName().length() == 6) {
            throw new Exception("asdasdasd");
        }
    }
}
