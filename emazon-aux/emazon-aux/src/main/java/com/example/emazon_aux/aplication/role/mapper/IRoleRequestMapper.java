package com.example.emazon_aux.aplication.role.mapper;

import com.example.emazon_aux.aplication.role.dto.request.RoleRequestDto;
import com.example.emazon_aux.domain.model.RoleModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleRequestMapper {

    RoleModel toRole(RoleRequestDto roleRequestDto);
}
