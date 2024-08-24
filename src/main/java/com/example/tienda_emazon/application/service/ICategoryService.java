package com.example.tienda_emazon.application.service;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.CategoryModel;

import java.util.List;

public interface ICategoryService {

    GenericResponse saveCategory(CategoryRequestDto requestDto);

    List<CategoryModel> getAllCategories();
}
