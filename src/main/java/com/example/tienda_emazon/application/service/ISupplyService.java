package com.example.tienda_emazon.application.service;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.PageableQuery;
import com.example.tienda_emazon.domain.model.SupplyModel;
import org.springframework.data.domain.Page;

public interface ISupplyService {

    GenericResponse saveSupply(SupplyRequestDto supplyRequestDto);

    Page<SupplyModel> getAllPages(PageableQuery pageableQuery);
}
