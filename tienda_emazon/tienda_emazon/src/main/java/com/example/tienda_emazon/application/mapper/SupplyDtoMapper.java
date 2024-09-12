package com.example.tienda_emazon.application.mapper;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.SupplyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyDtoMapper {

    SupplyRequestDto modelToDto (SupplyModel supplyModel);
    SupplyModel dtoToModel(SupplyRequestDto supplyRequestDto);

    default List<GenericResponse> toResponseList(List<SupplyModel> modelList){
        return modelList.stream().map(supplyModel-> {
            GenericResponse genericResponse = new GenericResponse();
            genericResponse.setDate(LocalDateTime.now());
            genericResponse.setMessage(supplyModel.getSupplyDescription());
            return genericResponse;
        }).toList();
    }

}
