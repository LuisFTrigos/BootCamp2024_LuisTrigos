package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.ISupplyServicePort;
import com.example.tienda_emazon.domain.exception.SupplyAlreadyExistsException;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.spi.ISupplyPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class SupplyUseCase implements ISupplyServicePort {

    private final ISupplyPersistencePort iSupplyPersistencePort;

    public SupplyUseCase(ISupplyPersistencePort iSupplyPersistencePort) {
        this.iSupplyPersistencePort = iSupplyPersistencePort;
    }

    @Override
    public void saveSupply(SupplyModel supplyModel) {
        SupplyModel supplyName = iSupplyPersistencePort.
                findSupplyByName(supplyModel.getName());
        if (supplyName != null) {
            throw new SupplyAlreadyExistsException("Articulo con nombre: "
                    + supplyName.getName() + " ya existe");
        }
        iSupplyPersistencePort.saveSupply(supplyModel);
    }

    @Override
    public Page<SupplyModel> pageSupply(Pageable pageable) {
        return null;
    }
}
