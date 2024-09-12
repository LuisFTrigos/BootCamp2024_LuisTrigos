package com.example.tienda_emazon.domain.model.api;

import javax.naming.Name;
import java.util.List;

public interface IProductServicePort {

    void saveName(Name name);

    List<Name> getName();

    Name getName(long nameReceived);

    void updateName(Name name);


    void deleteName(long nameReceived);



}

