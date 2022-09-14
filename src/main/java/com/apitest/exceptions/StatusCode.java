package com.apitest.exceptions;

public class StatusCode extends AssertionError{

    public StatusCode(String message, Throwable exception){
        super(message, exception);
    }
}
