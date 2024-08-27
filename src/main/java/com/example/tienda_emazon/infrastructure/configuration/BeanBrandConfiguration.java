package com.example.tienda_emazon.infrastructure.configuration;

import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import com.example.tienda_emazon.domain.usecase.BrandUseCase;
import com.example.tienda_emazon.infrastructure.out.adapter.BrandJpaAdapter;
import com.example.tienda_emazon.infrastructure.out.mapper.BrandEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanBrandConfiguration {
    private final BrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Bean
    public IBrandServicePort iBrandServicePort(){return  new BrandUseCase(iBrandPersistencePort());
    }

    @Bean
    public IBrandPersistencePort iBrandPersistencePort() {
        return new BrandJpaAdapter(brandRepository, brandEntityMapper);
    }
}
