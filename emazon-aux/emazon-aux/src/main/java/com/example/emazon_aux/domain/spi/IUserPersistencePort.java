package com.example.emazon_aux.domain.spi;

import com.example.emazon_aux.domain.model.UserModel;

import java.util.List;

public interface IUserPersistencePort {

    void saveUser(UserModel userModel);

    UserModel registerUser(UserModel userModel);
    boolean existsByName(String name);
    List<UserModel> getAllUsers();
}
