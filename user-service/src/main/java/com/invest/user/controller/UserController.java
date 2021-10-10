package com.invest.user.controller;

import com.invest.user.model.Person;
import com.invest.user.model.Trader;
import com.invest.user.service.AnalystService;
import com.invest.user.service.TraderService;
import com.invest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    AnalystService analystService;
    @Autowired
    TraderService traderService;

    @GetMapping("/user('{userId}')")
    public ResponseEntity<Person> getUserInfo(@PathVariable String userId, @RequestParam String type){
        return ResponseEntity.ok(getService(type).getUserById(userId));
    }

    @PostMapping("/user")
    public ResponseEntity<Person> addUser(@RequestBody Person person, @RequestParam String type){
        return ResponseEntity.ok(getService(type).postUser(person));
    }

    @DeleteMapping("/user('{userId}')")
    public ResponseEntity<String> deleteUser(@PathVariable String userId, @RequestParam String type){
        getService(type).deleteUserById(userId);
        return ResponseEntity.accepted().build();
    }

    public UserService getService(String type){
        UserService userService = null;
        switch(type){
            case "ANALYST" : userService = analystService;break;
            case "TRADER"  : userService = traderService; break;
        }
        return userService;
    }
}
