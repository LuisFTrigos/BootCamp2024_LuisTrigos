package com.example.emazon_aux.infrastructure.output.adapter;

import com.example.emazon_aux.domain.model.UserModel;
import com.example.emazon_aux.domain.spi.IUserPersistencePort;
import com.example.emazon_aux.infrastructure.output.entity.UserEntity;
import com.example.emazon_aux.infrastructure.output.mapper.IUserEntityMapper;
import com.example.emazon_aux.infrastructure.output.respository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {


    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public void saveUser(UserModel userModel) {
        UserEntity userEntity = userEntityMapper.toUserEntity(userModel);
        userRepository.save(userEntity);
    }

    @Override
    public UserModel registerUser(UserModel userModel) {
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return List.of();
    }
}
