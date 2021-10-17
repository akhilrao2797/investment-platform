package com.invest.auth.controller;

import com.invest.auth.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message/v1")
public class MessageController {

    @Autowired
    TwilioService twilioService;

    @GetMapping("/validate")
    public void validateOtp(@RequestParam String otp, @RequestParam String user) throws Exception {
        twilioService.validateOTP(otp, user);
    }

    @PostMapping("/send")
    public void sendOtp(@RequestParam String user){
        twilioService.sendOTP(user);
    }
}
