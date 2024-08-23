package com.example.tienda_emazon.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {

    private String error;
    private String message;
    public ErrorResponse(String error, String message){
        this.error = error;
        this.message = message;
    }
}
