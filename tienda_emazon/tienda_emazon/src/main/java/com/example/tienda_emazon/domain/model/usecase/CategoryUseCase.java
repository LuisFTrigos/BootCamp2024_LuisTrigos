package com.example.tienda_emazon.domain.model.usecase;

import com.example.tienda_emazon.domain.model.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.model.spi.ICategoryPersistencePort;

import javax.naming.Name;
import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;
    //Se define un constructor para inyectar dependecias
    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveName(Name name) {
        //comunicar lo que va que va pasar por el dominio y va a enviar a la persistencia
        //Se usa solamente el que está haciendo uso de esa interfaz
        categoryPersistencePort.saveName(name);
    }

    @Override
    public List<Name> getName() {
        return categoryPersistencePort.getName();
    }

    @Override
    public Name getName(long nameReceived) {
        return categoryPersistencePort.getName(nameReceived);
    }

    @Override
    public void updateName(Name name) {
        categoryPersistencePort.updateName(name);
    }

    @Override
    public void deleteName(long nameReceived) {
        categoryPersistencePort.deleteName(nameReceived);
    }
}
