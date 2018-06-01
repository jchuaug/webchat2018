package com.xmu.middleware.webchat2018.exception;


public class UserNotFoundException extends Exception {
    private  String message;
    public UserNotFoundException(){
    }

    public UserNotFoundException(String msg){
        super(msg);
    }

}
