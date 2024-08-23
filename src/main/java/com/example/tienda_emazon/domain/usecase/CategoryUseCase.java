package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    //Se define un constructor para inyectar dependecias
    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        //Si encontró un objeto, tiene apuntamiento de variable, sino apunta nulo
        CategoryModel categoryName = categoryPersistencePort.findCategoryByName(categoryModel.getName());
        if (categoryName != null) {
            throw new CategoryAlreadyExistsException("Categoría con nombre: " + categoryModel.getName() + " ya existe");
        }
        //comunicar lo que va que va pasar por el dominio y va a enviar a la persistencia
        //Se usa solamente el que está haciendo uso de esa interfaz
        categoryPersistencePort.saveCategory(categoryModel);
    }

    @Override
    public List<CategoryModel> listCategory() {
        categoryPersistencePort.listCategory();
        return categoryPersistencePort.listCategory();
    }
}
