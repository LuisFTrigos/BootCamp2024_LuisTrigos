package com.example.tienda_emazon.application.mapper;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.SupplyResponse;
import com.example.tienda_emazon.domain.model.SupplyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyDtoMapper {

    SupplyRequestDto modelToDto (SupplyModel supplyModel);
    SupplyModel dtoToModel(SupplyRequestDto supplyRequestDto);

    default List<SupplyResponse> toResponsePage(Page<SupplyModel> modelPage){
        return modelPage.stream().map(supplyModel -> {
            SupplyResponse supplyResponse = new SupplyResponse();
            supplyResponse.setSupplyName(supplyModel.getName());
            supplyResponse.setSupplyDescription(supplyModel.getDescription());
            supplyResponse.setSupplyAmount(supplyModel.getAmount());
            supplyResponse.setSupplyPrice(supplyModel.getPrice());
            return supplyResponse;
        }).toList();
    }

}
