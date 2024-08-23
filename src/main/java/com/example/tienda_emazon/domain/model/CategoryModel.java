package com.example.tienda_emazon.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryModel {

    // No debe tener anotaciones de entidad
    private long id;
    private String name;
    private String description;

    public CategoryModel() { /**/
    }


}
