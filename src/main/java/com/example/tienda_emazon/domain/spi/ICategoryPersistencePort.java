package com.example.tienda_emazon.domain.spi;
import com.example.tienda_emazon.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryPersistencePort {

    void saveCategory(CategoryModel categoryModel);

    List<CategoryModel> listCategory();

    CategoryModel findCategoryByName(String name);

}
