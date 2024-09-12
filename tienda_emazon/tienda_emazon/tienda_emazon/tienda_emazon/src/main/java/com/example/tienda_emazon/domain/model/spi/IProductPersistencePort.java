package com.example.tienda_emazon.domain.model.spi;

import javax.naming.Name;
import java.util.List;

public interface IProductPersistencePort {

    void saveName(Name name);

    List<Name> getName();

    Name getName(long nameReceived);

    void updateName(Name name);


    void deleteName(long nameReceived);
}
