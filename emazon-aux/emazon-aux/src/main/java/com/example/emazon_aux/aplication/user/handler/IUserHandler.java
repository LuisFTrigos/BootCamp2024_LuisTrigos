package com.example.emazon_aux.aplication.user.handler;

import com.example.emazon_aux.aplication.user.dto.request.UserRequestDto;
import com.example.emazon_aux.aplication.user.dto.request.login.LoginRegister;
import com.example.emazon_aux.aplication.user.dto.response.UserResponseDto;
import com.example.emazon_aux.domain.model.UserModel;

import java.util.List;

public interface IUserHandler {

    void saveUser(UserRequestDto userRequestDto);

    void registerUser(LoginRegister loginRegister);

    List<UserResponseDto> getAllUsers();

}
