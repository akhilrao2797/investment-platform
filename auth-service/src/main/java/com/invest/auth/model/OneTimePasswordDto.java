package com.invest.auth.model;

public class OneTimePasswordDto {

    private String userName;
    private String userId;
    private String otp;

    public String getUserName() {
        return userName;
    }

    public OneTimePasswordDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public OneTimePasswordDto setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getOtp() {
        return otp;
    }

    public OneTimePasswordDto setOtp(String otp) {
        this.otp = otp;
        return this;
    }
}
