package com.example.tienda_emazon.application.service.impl;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.infrastructure.out.respository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryServiceTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Autowired
    public CategoryServiceImpl categoryService;

    @Test
    void saveCategory() {
        //Given
        CategoryRequestDto categoryRequestDto = CategoryRequestDto
                .builder()
                .name("Test")
                .description("Test description")
                .build();

        GenericResponse genericResponse = new GenericResponse("test", LocalDateTime.now());

        String nameExpected = "Test";
        //When
        categoryService = new CategoryServiceImpl(categoryRequestDto);
        Mockito.when(categoryService.saveCategory(categoryRequestDto)).thenReturn(genericResponse);
        //Comportamiento del mock
        when(categoryRepository.existsByName(categoryRequestDto.getName())).thenReturn(false);
        //when(categoryRepository.save(categoryRequestDto)).thenReturn(categoryRequestDto);
        //Then
        assertNotNull(categoryRequestDto);
        verify(categoryRepository, times(1)).existsByName(categoryRequestDto.getName());
        verify(categoryService.saveCategory(categoryRequestDto), times(1));
    }
}