package com.diplomna.traders.exceptions;

public class CategoryNotFoundException extends AbstractRestException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
