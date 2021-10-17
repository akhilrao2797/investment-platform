package com.invest.auth.service;

import com.invest.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public User getUser(String userId){
        String url = "http://USER-SERVICE/user-sub/v1/user('" + userId + "')";
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
