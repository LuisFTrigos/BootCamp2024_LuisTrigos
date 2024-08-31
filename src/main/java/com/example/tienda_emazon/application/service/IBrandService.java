package com.example.tienda_emazon.application.service;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.query.PageableQuery;
import org.springframework.data.domain.Page;

public interface IBrandService {
    
    GenericResponse saveBrand(BrandRequestDto brandRequestDto);
    
    Page<BrandModel> getAll(PageableQuery pageableQuery);
}
