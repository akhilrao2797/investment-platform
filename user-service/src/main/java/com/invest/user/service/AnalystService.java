package com.invest.user.service;

import com.invest.user.model.Analyst;
import com.invest.user.model.Person;
import com.invest.user.model.Trader;
import com.invest.user.repository.AnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalystService implements UserService{

    @Autowired
    AnalystRepository analystRepository;

    @Override
    public Person getUserById(String userId) {
        return analystRepository.getOne(userId);
    }

    @Override
    public Person postUser(Person person) {
        return analystRepository.save((Analyst) person);
    }

    @Override
    public void deleteUserById(String userId) {
        analystRepository.deleteById(userId);
    }
}
