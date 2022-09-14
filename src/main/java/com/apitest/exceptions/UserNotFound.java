package com.apitest.exceptions;

public class UserNotFound extends AssertionError{

    public UserNotFound(String message, Throwable exception){
        super(message, exception);
    }

}
