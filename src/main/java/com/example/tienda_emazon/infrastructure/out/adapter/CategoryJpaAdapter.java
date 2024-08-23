package com.example.tienda_emazon.infrastructure.out.adapter;

import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import com.example.tienda_emazon.infrastructure.out.entity.CategoryEntity;
import com.example.tienda_emazon.infrastructure.out.mapper.CategoryEntityMapper;
import com.example.tienda_emazon.infrastructure.out.respository.CategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {


    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(CategoryModel categoryModel) {
        categoryRepository.save(categoryEntityMapper.modelToEntity(categoryModel));
    }

    @Override
    public List<CategoryModel> listCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        return categoryEntityMapper.toCategoryList(categoryEntityList);
    }

    @Override
    public CategoryModel findCategoryByName(String name) {
        return categoryEntityMapper.entityToModel(categoryRepository.findByName(name).orElse(null));
    }
}
