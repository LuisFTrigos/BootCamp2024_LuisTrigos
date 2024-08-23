package com.example.tienda_emazon.domain.exception;

public class CategoryAlreadyExistsException extends RuntimeException {

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
