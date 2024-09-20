package com.example.tienda_emazon.application.handler.impl;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.CategoryDtoMapper;
import com.example.tienda_emazon.application.handler.ICategoryHandler;
import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CategoryHandlerImpl implements ICategoryHandler {

    private final ICategoryServicePort categoryServicePort;
    private final CategoryDtoMapper categoryDtoMapper;

    public static final String CATEGORY_CREATED_SUCCESFULLY = "Se creó correctamente la categoría";

    @Override
    public GenericResponse saveCategory(CategoryRequestDto categoryDto){
        categoryServicePort.createCategory(categoryDtoMapper.dtoToModel(categoryDto));
        return GenericResponse.builder()
                .message(CATEGORY_CREATED_SUCCESFULLY)
                .date(LocalDateTime.now())
                .build();
    }

    @Override
    public CustomPage<CategoryModel> getCategoriesPaginated(PageRequestDomain pageRequestDomain) {
        return categoryServicePort.getAllPages(pageRequestDomain);
    }



}



