package com.example.emazon_aux.aplication.handler.impl;

import com.example.emazon_aux.aplication.dto.request.UserRequestDto;
import com.example.emazon_aux.aplication.dto.response.GenericResponse;
import com.example.emazon_aux.aplication.dto.response.UserResponseDto;
import com.example.emazon_aux.aplication.handler.IUserHandler;
import com.example.emazon_aux.aplication.mapper.IUserRequestMapper;
import com.example.emazon_aux.aplication.mapper.IUserResponseMapper;
import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.util.constants.Constants;
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

    @Override
    public GenericResponse saveUser(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUser(userRequestDto);
        userServicePort.saveUser(userModel);
        return GenericResponse.builder()
                .message(Constants.USER_CREATED_SUCCESFULLY)
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.getAllUsers());
    }
}
