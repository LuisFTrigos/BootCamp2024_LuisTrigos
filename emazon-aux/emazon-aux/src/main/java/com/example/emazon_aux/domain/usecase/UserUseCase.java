package com.example.emazon_aux.domain.usecase;

import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.exception.UserAlreadyExistsException;
import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.spi.IUserPersistencePort;
import com.example.emazon_aux.domain.util.constants.Constants;
import com.example.emazon_aux.domain.util.password.UserPasswordEncrypt;
import com.example.emazon_aux.domain.util.validations.Validations;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final UserPasswordEncrypt userPasswordEncrypt;

    public UserUseCase(IUserPersistencePort userPersistencePort, UserPasswordEncrypt userPasswordEncrypt) {
        this.userPersistencePort = userPersistencePort;
        this.userPasswordEncrypt = userPasswordEncrypt;
    }

    @Override
    public void saveUser(UserModel userModel) {
        Validations.validationsUser(userModel);
        userModel.setPassword(userPasswordEncrypt.passwordEncoder(userModel.getPassword()));
        userPersistencePort.saveUser(userModel);
        if (userPersistencePort.existsByName(userModel.getName())) {
            throw new UserAlreadyExistsException(Constants.USER_ALREADY_EXIST + userModel.getName());
        }
    }

    @Override
    public void registerUser(UserModel userModel) {
        Validations.validationsUser(userModel);
        userPersistencePort.registerUser(userModel);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }
}
