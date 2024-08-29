package com.example.tienda_emazon.domain.api;

import com.example.tienda_emazon.domain.model.SupplyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISupplyServicePort {

    void saveSupply(SupplyModel supplyModel);

    Page<SupplyModel> pageSupply(Pageable pageable);
}
