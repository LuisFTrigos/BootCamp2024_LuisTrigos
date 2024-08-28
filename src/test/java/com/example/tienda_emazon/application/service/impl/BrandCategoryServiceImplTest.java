package com.example.tienda_emazon.application.service.impl;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.mapper.BrandDtoMapper;
import com.example.tienda_emazon.domain.api.IBrandServicePort;
import com.example.tienda_emazon.domain.exception.InvalidDescriptionException;
import com.example.tienda_emazon.domain.model.BrandModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class BrandCategoryServiceImplTest {

    @Mock
    private BrandDtoMapper brandDtoMapper;
    @Mock
    private IBrandServicePort iBrandServicePort;
    @InjectMocks
    private BrandServiceImpl toTest;

    @Test
    void verifyTheServiceReturnsCorrectResultWhenSaveBrand() {
        BrandRequestDto brandRequestDto = new BrandRequestDto();

        BrandModel testBrandModel = new BrandModel();
        testBrandModel.setDescription(null);

        when(brandDtoMapper.dtoToModel(brandRequestDto))
                .thenReturn(testBrandModel);

        assertThrows(InvalidDescriptionException.class, () ->
                toTest.saveBrand(brandRequestDto));
        verify(iBrandServicePort, never()).saveBrand(any());

    }

    @Test
    void givenDateWhenBrandSavedSuccessfully() {
        BrandRequestDto brandRequestDto = new BrandRequestDto();

        BrandModel testBrandModel = new BrandModel();
        testBrandModel.setDescription("Description Text");

        when(brandDtoMapper.dtoToModel(brandRequestDto))
                .thenReturn(testBrandModel);
        GenericResponse genericResponse = toTest.saveBrand(brandRequestDto);
        assertNotNull(genericResponse);
        assertEquals(BrandServiceImpl.BRAND_CREATED_SUCCESFULLY,
                genericResponse.getMessage());
        assertNotNull(genericResponse.getDate());

    }

}
