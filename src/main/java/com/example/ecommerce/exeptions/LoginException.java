package com.example.ecommerce.exeptions;

public class LoginException extends RuntimeException {

    public LoginException(String message) {
        super(message);
    }
}
