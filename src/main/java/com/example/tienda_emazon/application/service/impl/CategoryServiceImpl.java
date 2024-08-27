package com.example.tienda_emazon.application.service.impl;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.CategoryDtoMapper;
import com.example.tienda_emazon.application.service.ICategoryService;
import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.exception.InvalidDescriptionException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryDtoMapper categoryDtoMapper;
    private final ICategoryServicePort categoryServicePort;

    public static final String CATEGORY_CREATED_SUCCESFULLY = "Se creó correctamente la categoría";

    @Override
    public GenericResponse saveCategory(CategoryRequestDto requestDto) {
        CategoryModel categoryModel = categoryDtoMapper.dtoToModel(requestDto);
        if (categoryModel.getDescription() == null) throw new InvalidDescriptionException("Descripción no valida");
        categoryServicePort.saveCategory(categoryModel);
        GenericResponse response = new GenericResponse();
        response.setMessage(CATEGORY_CREATED_SUCCESFULLY);
        response.setDate(LocalDateTime.now());
        return response;
    }

    @Override
    public List<CategoryModel> getAllCategories() {
        return categoryServicePort.listCategory();
    }
}



