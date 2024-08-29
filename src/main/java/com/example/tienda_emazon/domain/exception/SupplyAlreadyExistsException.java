package com.example.tienda_emazon.domain.exception;

public class SupplyAlreadyExistsException extends RuntimeException {

    public SupplyAlreadyExistsException(String message){
        super(message);
    }
}
