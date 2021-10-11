package com.invest.user.service;

import com.invest.user.model.Person;
import com.invest.user.model.Trader;
import com.invest.user.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraderService implements UserService {

    @Autowired
    TraderRepository traderRepository;

    @Override
    public Person getUserById(String userId) {
        return traderRepository.getOne(userId);
    }

    @Override
    public Person postUser(Person person) {
        return traderRepository.save((Trader) person);
    }

    @Override
    public void deleteUserById(String userId) {
        traderRepository.deleteById(userId);
    }
}
