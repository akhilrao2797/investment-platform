package com.invest.auth.util;

import com.invest.auth.model.User;

import java.text.DecimalFormat;
import java.util.Random;

public class MessageHelper {

    public static String generateOTP(){
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
