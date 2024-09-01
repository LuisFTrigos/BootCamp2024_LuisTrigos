package com.example.tienda_emazon.application.service.impl;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.SupplyDtoMapper;
import com.example.tienda_emazon.application.service.ISupplyService;
import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.exception.InvalidDescriptionException;
import com.example.tienda_emazon.domain.model.query.PageableQuery;
import com.example.tienda_emazon.domain.model.SupplyModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements ISupplyService {

    private final SupplyDtoMapper supplyDtoMapper;
    private final ISupplyServicePort iSupplyServicePort;

    public static final String SUPPLY_CREATED_SUCCESFULLY = "Se creó correctamente el articulo";

    @Override
    public GenericResponse saveSupply(SupplyRequestDto supplyRequestDto) {
        SupplyModel supplyModel = supplyDtoMapper.dtoToModel(supplyRequestDto);
        if (supplyModel.getDescription() == null)
            throw new InvalidDescriptionException("Descripción no valida");
        iSupplyServicePort.saveSupply(supplyModel);
        GenericResponse response = new GenericResponse();
        response.setMessage(SUPPLY_CREATED_SUCCESFULLY);
        response.setDate(LocalDateTime.now());
        return response;
    }

    @Override
    public Page<SupplyModel> getAllPages(PageableQuery pageableQuery) {
        try {
            String order = pageableQuery.getInOrder() != null ? pageableQuery.getInOrder() : "asc";
            String sortedBy = pageableQuery.getSortedBy() != null && !pageableQuery.getSortedBy().isEmpty()
                    ? pageableQuery.getSortedBy()
                    : "name";

            Sort sort = Sort.by(Sort.Direction.fromString(order), sortedBy);
            Pageable pageable = PageRequest.of(pageableQuery.getPage(), pageableQuery.getItemsPerPage(), sort);
            return iSupplyServicePort.pageSupply(pageable);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Page.empty();
    }


}
