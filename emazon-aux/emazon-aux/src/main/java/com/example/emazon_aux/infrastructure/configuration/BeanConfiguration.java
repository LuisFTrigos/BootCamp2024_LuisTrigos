package com.example.emazon_aux.infrastructure.configuration;

import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.spi.IUserPersistencePort;
import com.example.emazon_aux.domain.usecase.UserUseCase;
import com.example.emazon_aux.domain.util.password.UserPasswordEncrypt;
import com.example.emazon_aux.infrastructure.output.adapter.encrypt.UserPasswordEncryptImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    private final IUserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort, userPasswordEncrypt());
    }

    @Bean
    public UserPasswordEncrypt userPasswordEncrypt(){
        return new UserPasswordEncryptImpl(passwordEncoder);
    }
}
