package com.invest.lib.exception;

import com.invest.lib.util.ErrorCodeMapper;

public class UserNotFoundException extends RuntimeException{
    private int messageId;
    private String message;

    public UserNotFoundException(String message) {
        super(message);
//        this.messageId = ErrorCodeMapper.getValue(message);
    }

    public int getMessageId() {
        return messageId;
    }
}
