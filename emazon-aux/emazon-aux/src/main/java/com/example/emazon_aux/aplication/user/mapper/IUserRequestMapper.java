package com.example.emazon_aux.aplication.user.mapper;


import com.example.emazon_aux.aplication.user.dto.request.UserRequestDto;
import com.example.emazon_aux.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    UserModel toUser(UserRequestDto userRequestDto);


}
