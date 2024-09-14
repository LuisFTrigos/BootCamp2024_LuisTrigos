package com.example.emazon_aux.aplication.handler.impl;

import com.example.emazon_aux.aplication.dto.request.UserRequestDto;
import com.example.emazon_aux.aplication.dto.response.UserResponseDto;
import com.example.emazon_aux.aplication.handler.IUserHandler;
import com.example.emazon_aux.aplication.mapper.IUserRequestMapper;
import com.example.emazon_aux.aplication.mapper.IUserResponseMapper;
import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.util.constants.Constants;
import com.example.emazon_aux.domain.util.password.UserPasswordEncrypt;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        UserResponseDto.builder()
                .message(Constants.USER_CREATED_SUCCESFULLY)
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }
}
