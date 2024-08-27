package com.example.tienda_emazon.infrastructure.configuration;

import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.domain.usecase.CategoryUseCase;
import com.example.tienda_emazon.infrastructure.out.adapter.CategoryJpaAdapter;
import com.example.tienda_emazon.infrastructure.out.mapper.CategoryEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanCategoryConfiguration {
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryServicePort iCategoryServicePort(){
        return new CategoryUseCase(iCategoryPersistencePort());
    }

    @Bean
    public ICategoryPersistencePort iCategoryPersistencePort(){
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }
}
