package com.luisfetrigos.emazon_authenticate.aplication.mapper;

import com.luisfetrigos.emazon_authenticate.aplication.dto.response.RoleResponseDto;
import com.luisfetrigos.emazon_authenticate.domain.model.RoleModel;

import java.util.List;

public interface RoleResponseMapper {

    RoleResponseDto toResponse(RoleModel roleModel);

    List<RoleResponseDto> toResponseList(List<RoleModel> roleModelList);
}
