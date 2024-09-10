package com.example.tienda_emazon.infrastructure.out.mapper;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.infrastructure.out.entity.CategoryEntity;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyEntityMapper {
    SupplyEntity modelToEntity(SupplyModel supplyModel);
    @Mapping(target = "associatedCategories", source = "supplyCategories")
    SupplyModel entityToModel(SupplyEntity supplyEntity);
    List<SupplyModel> entityListModelList(List<SupplyEntity> supplyEntityList);

    default List<String> mapCategories(List<CategoryEntity> categories) {
        return categories.stream()
                .map(CategoryEntity::getCategoryName)
                .collect(Collectors.toList());
    }


}
