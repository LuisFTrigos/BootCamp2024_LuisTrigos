package com.example.emazon_aux.domain.usecase;

import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.spi.IUserPersistencePort;
import com.example.emazon_aux.domain.util.validations.Validations;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(UserModel userModel) {
        Validations valid = new Validations();
        userPersistencePort.saveUser(userModel);
    }

    @Override
    public void registerUser(UserModel userModel) {
        Validations valid = new Validations();
        userPersistencePort.registerUser(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }
}
