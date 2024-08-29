package com.example.tienda_emazon.domain.spi;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import org.springframework.data.domain.Page;

public interface ISupplyPersistencePort {

    void saveSupply(SupplyModel supplyModel);

    Page<SupplyEntity> pageSupply(int pageNumber, int pageSize);

    SupplyModel findSupplyByName(String name);
}
