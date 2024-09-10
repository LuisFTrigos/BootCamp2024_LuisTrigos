package com.example.tienda_emazon.infrastructure.out.mapper;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyEntityMapper {

    SupplyEntity modelToEntity(SupplyModel supplyModel);
    SupplyModel entityToModel(SupplyEntity supplyEntity);
    List<SupplyModel> entityListModelList(List<SupplyEntity> supplyEntityList);
}
