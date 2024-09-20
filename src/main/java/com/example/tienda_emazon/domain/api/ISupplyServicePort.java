package com.example.tienda_emazon.domain.api;

import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;

public interface ISupplyServicePort {

    SupplyModel createSupply(SupplyModel supplyModel);
    CustomPage<SupplyModel> getSuppliesPaginated(PageRequestDomain pageRequest);
}
