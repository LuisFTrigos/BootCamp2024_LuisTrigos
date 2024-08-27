package com.example.tienda_emazon.application.service.impl;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.BrandDtoMapper;
import com.example.tienda_emazon.application.service.IBrandService;
import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.exception.InvalidDescriptionException;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.PageableQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandService {

    private final BrandDtoMapper brandDtoMapper;
    private final IBrandServicePort brandServicePort;

    public static final String BRAND_CREATED_SUCCESFULLY = "Se creó correctamente la marca";

    @Override
    public GenericResponse saveBrand(BrandRequestDto brandRequestDto) {
        BrandModel brandModel = brandDtoMapper.dtoToModel(brandRequestDto);
        if (brandModel.getDescription() == null) throw new InvalidDescriptionException("Descripción no valida");
        brandServicePort.saveBrand(brandModel);
        GenericResponse response = new GenericResponse();
        response.setMessage(BRAND_CREATED_SUCCESFULLY);
        response.setDate(LocalDateTime.now());
        return response;
    }

    @Override
    public Page<BrandModel> getAll(PageableQuery pageableQuery) {
        Sort sort = Sort.by(Sort.Direction.fromString(pageableQuery.getInOrder()),
                pageableQuery.getSortedBy());
        Pageable pageable = PageRequest.of(pageableQuery.getPage(),
                pageableQuery.getItemsPerPage(), sort);
        return brandServicePort.findAll(pageable);
    }
}
