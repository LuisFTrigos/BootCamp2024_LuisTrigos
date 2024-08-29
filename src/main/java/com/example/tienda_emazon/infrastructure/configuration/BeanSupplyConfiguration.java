package com.example.tienda_emazon.infrastructure.configuration;

import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import com.example.tienda_emazon.domain.usecase.SupplyUseCase;
import com.example.tienda_emazon.infrastructure.out.adapter.SupplyJpaAdapter;
import com.example.tienda_emazon.infrastructure.out.mapper.SupplyEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanSupplyConfiguration {
    private final SupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Bean
    public ISupplyServicePort iSupplyServicePort(){
        return new SupplyUseCase(iSupplyPersistencePort());
    }

    @Bean
    public ISupplyPersistencePort iSupplyPersistencePort(){
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

}
