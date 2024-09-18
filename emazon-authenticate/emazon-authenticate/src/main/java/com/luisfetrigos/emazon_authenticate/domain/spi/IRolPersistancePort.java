package com.luisfetrigos.emazon_authenticate.domain.spi;

import com.luisfetrigos.emazon_authenticate.domain.model.RoleModel;

import java.util.List;

public interface IRolPersistancePort {

    List<RoleModel> getAllRoles();
}
