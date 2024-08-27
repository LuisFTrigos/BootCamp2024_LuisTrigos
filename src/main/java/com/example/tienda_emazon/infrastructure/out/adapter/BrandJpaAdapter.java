package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import com.example.tienda_emazon.infrastructure.out.entity.BrandEntity;
import com.example.tienda_emazon.infrastructure.out.mapper.BrandEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistencePort {

    private final BrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public void saveBrand(BrandModel brandModel) {
        brandRepository.save(brandEntityMapper.modelToEntity(brandModel));
    }

    public Page<BrandEntity> pageBrand(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return brandRepository.findAll(pageable);
    }

    @Override
    public BrandModel findBrandByName(String name) {
        return brandEntityMapper.entityToModel
                (brandRepository.findByName(name).orElse(null));
    }
}
