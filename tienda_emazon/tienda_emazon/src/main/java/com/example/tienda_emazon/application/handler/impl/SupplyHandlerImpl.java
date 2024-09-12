package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISupplyHandler;
import com.example.tienda_emazon.application.mapper.SupplyDtoMapper;
import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SupplyHandlerImpl implements ISupplyHandler {

    private final ISupplyServicePort supplyServicePort;
    private final SupplyDtoMapper supplyDtoMapper;

    public static final String SUPPLY_CREATED_SUCCESFULLY = "Se creó correctamente el articulo";

    @Override
    public GenericResponse saveSupply(SupplyRequestDto requestDto) {
        supplyServicePort.createSupply(supplyDtoMapper.dtoToModel(requestDto));
        return GenericResponse.builder()
                .message(SUPPLY_CREATED_SUCCESFULLY)
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public CustomPage<SupplyModel> getSuppliesPaginated(PageRequestDomain pageRequest) {
        return supplyServicePort.getSuppliesPaginated(pageRequest);
    }
}
