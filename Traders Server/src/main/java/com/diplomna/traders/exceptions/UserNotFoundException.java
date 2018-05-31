package com.diplomna.traders.exceptions;

public class UserNotFoundException extends AbstractRestException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
