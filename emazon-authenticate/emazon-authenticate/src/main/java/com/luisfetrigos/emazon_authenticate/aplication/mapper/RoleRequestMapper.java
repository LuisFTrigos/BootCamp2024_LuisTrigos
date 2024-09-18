package com.luisfetrigos.emazon_authenticate.aplication.mapper;

import com.luisfetrigos.emazon_authenticate.aplication.dto.request.RoleRequestDto;
import com.luisfetrigos.emazon_authenticate.domain.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleRequestMapper {

    RoleModel toRole(RoleRequestDto roleRequestDto);
}
