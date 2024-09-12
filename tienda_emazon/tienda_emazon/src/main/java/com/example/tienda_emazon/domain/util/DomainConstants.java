package com.example.tienda_emazon.domain.util;

public class DomainConstants {

    private DomainConstants(){
        //Constantes
    }

    //Generic
    public static final String INVALID_DESCRIPTION = "La descripcion es obligatoria";
    public static final String INVALID_NAME = "El Nombre es obligatorio";
    public static final String INVALID_NAME_SIZE = "El nombre debe tener más de 5 y menos de 50 caracteres";
    public static final String INVALID_DESCRIPTION_SIZE = "La descripción debe tener más de 5 y menos de 50 caracteres";

    //Category
    public static final String CATEGORY_ALREADY_EXIST = "Categoria ya existente: ";
    //Brand
    public static final String BRAND_ALREADY_EXIST = "Marca ya existente: ";
    //Supply
    public static final String INVALID_SUPPLY = "Al menos una categoría debe estar asociada a este articulo";
    public static final String INVALID_ASSOCIATED_CATEGORIES = "Un articulo no puede tener más de 3 categorías asociadas";
    public static final String SUPPLY_ALREADY_EXIST = "Articulo ya existente";
}
