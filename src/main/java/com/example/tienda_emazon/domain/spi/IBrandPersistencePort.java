package com.example.tienda_emazon.domain.spi;

import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.infrastructure.out.entity.BrandEntity;
import org.springframework.data.domain.Page;

public interface IBrandPersistencePort {

    void saveBrand(BrandModel brandModel);

    Page<BrandEntity> pageBrand(int pageNumber, int pageSize);

    BrandModel findBrandByName(String name);
}
