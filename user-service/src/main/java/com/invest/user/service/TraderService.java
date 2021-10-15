package com.invest.user.service;

import com.invest.lib.exception.UserNotFoundException;
import com.invest.user.model.Person;
import com.invest.user.model.Trader;
import com.invest.user.repository.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TraderService implements UserService {

    @Autowired
    TraderRepository traderRepository;

    @Override
    public Trader getUserById(String userId) {
        Optional<Trader> traderOptional = traderRepository.findById(userId);
        if(traderOptional.isPresent())
            return traderOptional.get();
        else
            throw new UserNotFoundException("Trader: " + userId + " not found");
    }

    @Override
    public Trader postUser(Person person) {
        return traderRepository.save((Trader) person);
    }

    @Override
    public void deleteUserById(String userId) {
        Trader trader = getUserById(userId);
        traderRepository.delete(trader);
    }
}
