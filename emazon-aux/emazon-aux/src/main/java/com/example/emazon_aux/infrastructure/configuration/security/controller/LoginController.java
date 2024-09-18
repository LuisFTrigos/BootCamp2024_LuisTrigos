package com.example.emazon_aux.infrastructure.configuration.security.controller;

import com.example.emazon_aux.aplication.dto.request.LoginRegister;
import com.example.emazon_aux.aplication.handler.IUserHandler;
import com.example.emazon_aux.infrastructure.configuration.security.dto.AuthCredentials;
import com.example.emazon_aux.infrastructure.configuration.security.dto.LoginResponse;
import com.example.emazon_aux.infrastructure.configuration.security.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final IUserHandler userHandler;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody AuthCredentials authCredentials) {
        return LoginResponse.builder()
                .token(loginService.login(authCredentials))
                .build();
    }

    @PostMapping("/register")
    public ResponseEntity<Void> loginResponse(@RequestBody LoginRegister loginRegister) {
        userHandler.registerUser(loginRegister);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
