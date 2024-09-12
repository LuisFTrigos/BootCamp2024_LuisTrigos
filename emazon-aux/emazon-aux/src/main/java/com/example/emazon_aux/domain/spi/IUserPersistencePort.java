package com.example.emazon_aux.domain.spi;

import com.example.emazon_aux.domain.model.UserModel;

import java.util.List;

public interface IUserPersistencePort {

    UserModel saveUser(UserModel userModel);

    UserModel registerUser(UserModel userModel);

    List<UserModel> getAllUsers();
}
