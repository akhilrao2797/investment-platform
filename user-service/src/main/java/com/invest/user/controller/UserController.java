package com.invest.user.controller;

import com.invest.user.model.Analyst;
import com.invest.user.model.Person;
import com.invest.user.model.Trader;
import com.invest.user.service.AnalystService;
import com.invest.user.service.TraderService;
import com.invest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.invest.user.util.UserServiceFactory.getService;

@RestController
@RequestMapping("/user-sub/v1")
public class UserController {

    @GetMapping("/user('{userId}')")
    public ResponseEntity<Person> getUserInfo(@PathVariable String userId, @RequestParam String type){
        Person userById = getService(type).getUserById(userId);
        return ResponseEntity.ok(userById);
    }

    @PostMapping("/user")
    public ResponseEntity<Person> addUser(@RequestBody Person person, @RequestParam String type){
        Person user = getService(type).postUser(person);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/analyst")
    public ResponseEntity<Person> addAnalyst(@RequestBody Analyst analyst){
        Person user = getService("ANALYST").postUser(analyst);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/trader")
    public ResponseEntity<Person> addTrader(@RequestBody Trader trader){
        Person user = getService("TRADER").postUser(trader);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user('{userId}')")
    public ResponseEntity<String> deleteUser(@PathVariable String userId, @RequestParam String type){
        getService(type).deleteUserById(userId);
        return ResponseEntity.accepted().build();
    }
}
