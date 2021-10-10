package com.invest.user.service;

import com.invest.user.model.Person;

public interface UserService {

    Person getUserById(String userId);
    Person postUser(Person person);
    void deleteUserById(String userId);
}

