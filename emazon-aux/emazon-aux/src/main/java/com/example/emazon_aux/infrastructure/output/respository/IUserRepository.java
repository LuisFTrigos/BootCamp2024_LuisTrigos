package com.example.emazon_aux.infrastructure.output.respository;

import com.example.emazon_aux.infrastructure.output.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findOneByEmail(String name);
}
