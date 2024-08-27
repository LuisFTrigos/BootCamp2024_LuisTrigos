package com.example.tienda_emazon.domain.exception;

public class BrandAlreadyExistsException extends RuntimeException{

    public BrandAlreadyExistsException(String message){
        super(message);
    }

}
