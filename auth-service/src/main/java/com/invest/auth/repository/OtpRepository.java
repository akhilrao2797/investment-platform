package com.invest.auth.repository;

import com.invest.auth.model.OneTimePasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class OtpRepository {

    private RedisTemplate<String, OneTimePasswordDto> redisTemplate;
    private HashOperations hashOperations;
    private static final String USER_OTP_REPO = "USER-OTP";

    @Autowired
    OtpRepository(RedisTemplate<String, OneTimePasswordDto> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
        redisTemplate.expire(USER_OTP_REPO, 2, TimeUnit.MINUTES);
    }

    public void save(OneTimePasswordDto otp){
        hashOperations.put(USER_OTP_REPO, otp.getUserId(), otp);
    }

    public OneTimePasswordDto findById(String id){
        return (OneTimePasswordDto) hashOperations.get(USER_OTP_REPO, id);
    }
}