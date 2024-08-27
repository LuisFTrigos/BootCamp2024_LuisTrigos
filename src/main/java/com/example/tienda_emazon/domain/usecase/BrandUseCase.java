package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.exception.BrandAlreadyExistsException;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort iBrandPersistencePort;

    public BrandUseCase(IBrandPersistencePort iBrandPersistencePort) {
        this.iBrandPersistencePort = iBrandPersistencePort;
    }

    @Override
    public void saveBrand(BrandModel brandModel) {
        BrandModel brandName = iBrandPersistencePort.
                findBrandByName(brandModel.getName());
        if (brandName != null){
            throw new BrandAlreadyExistsException("Marca con nombre: " + brandModel.getName() + " ya existe");
        }
        iBrandPersistencePort.saveBrand(brandModel);
    }

    @Override
    public List<BrandModel> listBrand() {
        return iBrandPersistencePort.listBrand();
    }
}
