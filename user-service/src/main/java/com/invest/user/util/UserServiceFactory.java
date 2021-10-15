package com.invest.user.util;

import com.invest.user.service.AnalystService;
import com.invest.user.service.TraderService;
import com.invest.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFactory {

    static AnalystService analystService;
    static TraderService traderService;

    @Autowired
    public void initialize(AnalystService analystService, TraderService traderService){
        UserServiceFactory.analystService = analystService;
        UserServiceFactory.traderService = traderService;
    }

    public static UserService getService(String type){
        UserService userService = null;
        type = type.toUpperCase();
        switch(type){
            case "ANALYST" : userService = analystService;break;
            case "TRADER"  : userService = traderService; break;
        }
        return userService;
    }
}
