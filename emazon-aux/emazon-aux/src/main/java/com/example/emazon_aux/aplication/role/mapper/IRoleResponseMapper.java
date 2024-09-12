package com.example.emazon_aux.aplication.role.mapper;

import com.example.emazon_aux.aplication.role.dto.response.RoleResponseDto;
import com.example.emazon_aux.domain.model.RoleModel;

import java.util.List;

public interface IRoleResponseMapper {


    RoleResponseDto toResponse(RoleModel roleModel);

    List<RoleResponseDto> toResponseList(List<RoleModel> roleModelList);
}
