package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.exception.BrandAlreadyExistsException;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BrandUseCaseTest {

    @InjectMocks
    public BrandUseCase toTest;
    @Mock
    private IBrandPersistencePort iBrandPersistencePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenValidBrandWhenSavingThenShouldSaveBrandSuccessfully() {
        BrandModel brandModel = new BrandModel();
        brandModel.setName("Brand Test");

        Mockito.when(iBrandPersistencePort.findBrandByName
                (brandModel.getName())).thenReturn(null);

        toTest.saveBrand(brandModel);

        verify(iBrandPersistencePort,
                times(1))
                .saveBrand(brandModel);
        assertEquals("Brand Test", brandModel.getName());
    }

    @Test
    void givenBrandWhenBrandAlreadyExistThenShouldThrowException() {
        BrandModel brandModel = new BrandModel();
        brandModel.setName("Brand Test");

        Mockito.when(iBrandPersistencePort.findBrandByName
                (brandModel.getName())).thenReturn(new BrandModel());

        assertThrows(BrandAlreadyExistsException.class,
                () -> toTest.saveBrand(brandModel));
        verify(iBrandPersistencePort,
                Mockito.never())
                .saveBrand(any(BrandModel.class));
    }
}
