package com.example.tienda_emazon.domain.api;

import com.example.tienda_emazon.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryServicePort {

    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> listCategory();

}
