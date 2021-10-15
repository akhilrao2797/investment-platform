package com.invest.user.service;

import com.invest.lib.exception.UserNotFoundException;
import com.invest.user.model.Analyst;
import com.invest.user.model.Person;
import com.invest.user.model.Trader;
import com.invest.user.repository.AnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnalystService implements UserService{

    @Autowired
    AnalystRepository analystRepository;

    @Override
    public Analyst getUserById(String userId) {
        Optional<Analyst> analystOptional = analystRepository.findById(userId);
        if(analystOptional.isPresent())
            return analystOptional.get();
        else
            throw new UserNotFoundException("Analyst: " + userId + " not found");
    }

    @Override
    public Analyst postUser(Person person) {
        return analystRepository.save((Analyst) person);
    }

    @Override
    public void deleteUserById(String userId) {
        Analyst analyst = getUserById(userId);
        analystRepository.delete(analyst);
    }
}
