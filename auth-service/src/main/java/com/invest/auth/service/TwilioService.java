package com.invest.auth.service;

import com.invest.auth.config.TwilioConfig;
import com.invest.auth.model.OneTimePasswordDto;
import com.invest.auth.model.User;
import com.invest.auth.repository.OtpRepository;
import com.invest.auth.util.MessageHelper;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class TwilioService {

    @Autowired
    TwilioConfig twilioConfig;
    @Autowired
    UserService userService;
    @Autowired
    OtpRepository otpRepository;

    public void sendOTP(String userId) {
        String generatedOtp = MessageHelper.generateOTP();
        User user = userService.getUser(userId);
        String messageContent = getMessage(user, generatedOtp);

        Message message = Message.
                creator(new PhoneNumber(user.getPhoneNumber()),
                        new PhoneNumber(twilioConfig.getTrailNumber()),
                        messageContent)
                .create();

        OneTimePasswordDto otp = new OneTimePasswordDto()
                .setOtp(generatedOtp)
                .setUserId(user.getUserId())
                .setUserName(user.getUserName());

        otpRepository.save(otp);
    }

    private String getMessage(User user, String otp) {
        return new StringBuilder("Hi ")
                .append(user.getUserName())
                .append(", Your OTP is ")
                .append(otp)
                .append(". Valid only for 2 minutes. Thank you.")
                .toString();
    }

    public String validateOTP(String receivedOtp, String userId) throws Exception {
        if(ObjectUtils.isEmpty(userId))
            throw new Exception("Invalid user");
        OneTimePasswordDto otpDetails = otpRepository.findById(userId);
        if(otpDetails != null && otpDetails.getOtp().equals(receivedOtp))
            return "Valid OTP";
        else
            throw new Exception("Invalid request. Request for a new OTP");

    }
}
