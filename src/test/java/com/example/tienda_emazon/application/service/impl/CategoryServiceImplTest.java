package com.example.tienda_emazon.application.service.impl;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.CategoryDtoMapper;
import com.example.tienda_emazon.domain.api.ICategoryServicePort;
import com.example.tienda_emazon.domain.exception.InvalidDescriptionException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryDtoMapper categoryDtoMapper;
    @Mock
    private ICategoryServicePort iCategoryServicePort;
    @InjectMocks
    private CategoryServiceImpl toTest;

    @Test
    void verifyTheServiceReturnsCorrectResultWhenSaveCategory() {
      CategoryRequestDto categoryRequestDto = new CategoryRequestDto();

      CategoryModel testCategoryModel = new CategoryModel();
      testCategoryModel.setDescription(null);

      when(categoryDtoMapper.dtoToModel(categoryRequestDto))
              .thenReturn(testCategoryModel);

      assertThrows(InvalidDescriptionException.class, () ->
              toTest.saveCategory(categoryRequestDto));
      verify(iCategoryServicePort, never()).saveCategory(any());

    }

    @Test
    void givenDateWhenCategorySavedSuccessfully() {
        CategoryRequestDto categoryRequestDto = new CategoryRequestDto();

        CategoryModel testCategoryModel = new CategoryModel();
        testCategoryModel.setDescription("Description Text");

        when(categoryDtoMapper.dtoToModel(categoryRequestDto))
                .thenReturn(testCategoryModel);
        GenericResponse genericResponse = toTest.saveCategory(categoryRequestDto);
        assertNotNull(genericResponse);
        assertEquals(CategoryServiceImpl.CATEGORY_CREATED_SUCCESFULLY,
                genericResponse.getMessage());
        assertNotNull(genericResponse.getDate());

    }
}