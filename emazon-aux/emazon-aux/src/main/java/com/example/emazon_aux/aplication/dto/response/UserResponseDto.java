package com.example.emazon_aux.aplication.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String name;

    private String lastName;

    private int document;

    private String phone;

    private String email;

}
