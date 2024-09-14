package com.example.emazon_aux.infrastructure.configuration;

import com.example.emazon_aux.domain.api.IUserServicePort;
import com.example.emazon_aux.domain.spi.IUserPersistencePort;
import com.example.emazon_aux.domain.usecase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    private final IUserPersistencePort userPersistencePort;

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort);
    }
}
