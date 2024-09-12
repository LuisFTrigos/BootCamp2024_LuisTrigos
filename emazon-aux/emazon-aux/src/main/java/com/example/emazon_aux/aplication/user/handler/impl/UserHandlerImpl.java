package com.example.emazon_aux.aplication.user.handler.impl;

import com.example.emazon_aux.aplication.user.dto.request.UserRequestDto;
import com.example.emazon_aux.aplication.user.dto.request.login.LoginRegister;
import com.example.emazon_aux.aplication.user.dto.response.UserResponseDto;
import com.example.emazon_aux.aplication.user.handler.IUserHandler;
import com.example.emazon_aux.aplication.user.mapper.IUserRequestMapper;
import com.example.emazon_aux.aplication.user.mapper.IUserResponseMapper;
import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.util.password.UserPasswordEncrypt;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;
    private final UserPasswordEncrypt userPasswordEncrypt;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {

        userRequestDto.setPassword(userPasswordEncrypt.passwordEncoder(userRequestDto.getPassword()));
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(userModel);
    }

    @Override
    public void registerUser(LoginRegister loginRegister) {
        loginRegister.setPassword(userPasswordEncrypt.passwordEncoder(loginRegister.getPassword()));
        UserModel userModel = new UserModel();
        userModel.setName(loginRegister.getName());
        userModel.setLastName(loginRegister.getLastName());
        userModel.setEmail(loginRegister.getEmail());
        userModel.setPhone(loginRegister.getPhone());
        userModel.setPassword(loginRegister.getPassword());
        userModel.setDocument(loginRegister.getDocument());

        userServicePort.registerUser(userModel);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }
}
