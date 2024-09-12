package com.example.tienda_emazon.domain.model.usecase;

import com.example.tienda_emazon.domain.model.api.IProductServicePort;
import com.example.tienda_emazon.domain.model.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.domain.model.spi.IProductPersistencePort;

import javax.naming.Name;
import java.util.List;

    public class ProductUseCase implements IProductServicePort {

        private final IProductPersistencePort productPersistencePort;
        //Se define un constructor para inyectar dependecias
        public ProductUseCase(IProductPersistencePort productPersistencePort) {

            this.productPersistencePort = productPersistencePort;
        }

        @Override
        public void saveName(Name name) {
            //comunicar lo que va que va pasar por el dominio y va a enviar a la persistencia
            //Se usa solamente el que está haciendo uso de esa interfaz
            productPersistencePort.saveName(name);
        }

        @Override
        public List<Name> getName() {
            return productPersistencePort.getName();
        }

        @Override
        public Name getName(long nameReceived) {
            return productPersistencePort.getName(nameReceived);
        }

        @Override
        public void updateName(Name name) {
            productPersistencePort.updateName(name);
        }

        @Override
        public void deleteName(long nameReceived) {
            productPersistencePort.deleteName(nameReceived);
        }
}
