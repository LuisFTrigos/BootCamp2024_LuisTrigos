package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        CategoryModel categoryName = categoryPersistencePort.findCategoryByName(categoryModel.getName());
        if (categoryName != null) {
            throw new CategoryAlreadyExistsException("Categoría con nombre: " + categoryModel.getName() + " ya existe");
        }

        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryModel> listCategory() {
        return categoryPersistencePort.listCategory();
    }

}
