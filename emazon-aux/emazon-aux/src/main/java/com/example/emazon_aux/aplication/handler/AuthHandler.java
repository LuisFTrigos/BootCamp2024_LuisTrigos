package com.example.emazon_aux.aplication.handler;

import com.example.emazon_aux.aplication.dto.request.LoginRegister;
import com.example.emazon_aux.aplication.dto.request.UserRequestDto;
import com.example.emazon_aux.aplication.dto.response.JwtResponseDto;

import java.text.ParseException;

public interface AuthHandler {
    JwtResponseDto login(LoginRegister loginRegister);
    JwtResponseDto refresh(JwtResponseDto jwtResponseDto) throws ParseException;
    void register(UserRequestDto userRegister);
}
