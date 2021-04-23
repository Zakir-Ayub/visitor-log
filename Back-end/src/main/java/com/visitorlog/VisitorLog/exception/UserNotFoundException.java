package com.visitorlog.VisitorLog.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
