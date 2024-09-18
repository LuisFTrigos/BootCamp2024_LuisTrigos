package com.example.emazon_aux.infrastructure.configuration.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthCredentials {

    private String email;
    private String password;

}
