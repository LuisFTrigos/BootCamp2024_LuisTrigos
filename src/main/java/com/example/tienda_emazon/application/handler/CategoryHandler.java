package com.example.tienda_emazon.application.handler;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.CategoryDtoMapper;
import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.model.CategoryModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryServicePort categoryServicePort;
    private  final CategoryDtoMapper categoryDtoMapper;



    @Override
    public void saveCategoryList(CategoryRequestDto categoryRequestDto) {
        CategoryModel categoryModel = categoryDtoMapper.dtoToModel(categoryRequestDto);
        categoryServicePort.saveCategory(categoryModel);
    }

    @Override
    public List<GenericResponse> getAllCategoriesList() {
        return categoryDtoMapper.toResponseList(categoryServicePort.listCategory());
    }

}
