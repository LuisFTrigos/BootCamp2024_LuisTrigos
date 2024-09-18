package com.example.emazon_aux.aplication.dto.response;

import lombok.*;

import java.time.LocalDate;


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
    private LocalDate birthday;

}
