package com.example.tienda_emazon.domain.api;

import com.example.tienda_emazon.domain.model.BrandModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBrandServicePort {

    void saveBrand(BrandModel brandModel);

    Page<BrandModel> findAll(Pageable pageable);
}
