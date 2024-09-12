package com.example.emazon_aux.domain.spi;

import com.example.emazon_aux.domain.model.RoleModel;

import java.util.List;

public interface IRolePersistencePort {

    List<RoleModel> getAllRoles();
}
