package com.example.emazon_aux.aplication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRegister {


    private String name;
    private String lastName;
    private int document;
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Must be a well-formed email address")
    private String email;
    private String phone;
    @NotBlank(message = "Password must not be empty")
    private String password;
}
