package com.restful.api.example.services.api;

import com.restful.api.example.exceptions.InvalidLengthExceptionInner;
import com.restful.api.example.models.RandomUserModel;

public interface SomeService {
    RandomUserModel getRandomUser();
    void setRandomUser(RandomUserModel randomUser) throws Exception;
}
