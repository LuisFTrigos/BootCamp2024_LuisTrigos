package com.example.emazon_aux.domain.api;

import com.example.emazon_aux.domain.model.RoleModel;

import java.util.List;

public interface IRoleServicePort {

    List<RoleModel> getAllRoles();
}
