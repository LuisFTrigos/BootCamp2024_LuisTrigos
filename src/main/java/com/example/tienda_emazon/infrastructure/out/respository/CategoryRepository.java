package com.example.tienda_emazon.infrastructure.out.respository;

import com.example.tienda_emazon.infrastructure.out.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);

    Optional<CategoryEntity> findByName(String name);




}
