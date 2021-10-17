package com.invest.auth;

import com.invest.auth.config.TwilioConfig;
import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AuthServiceApplication {

    @Autowired
    TwilioConfig twilioConfig;

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @PostConstruct
    public void initTwilioConfig(){
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }
}
