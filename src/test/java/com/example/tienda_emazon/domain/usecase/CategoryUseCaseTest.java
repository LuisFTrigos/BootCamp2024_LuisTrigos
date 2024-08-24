package com.example.tienda_emazon.domain.usecase;

import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CategoryUseCaseTest {

    @InjectMocks
    public CategoryUseCase toTest;
    @Mock
    private ICategoryPersistencePort iCategoryPersistencePort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenValidCategoryWhenSavingThenShouldSaveCategorySuccessfully() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName("Category Test");

        Mockito.when(iCategoryPersistencePort.findCategoryByName
                (categoryModel.getName())).thenReturn(null);

        toTest.saveCategory(categoryModel);

        verify(iCategoryPersistencePort,
                times(1))
                .saveCategory(categoryModel);
        assertEquals("Category Test", categoryModel.getName());
    }

    @Test
    void givenCategoryWhenCategoryAlreadyExistThenShouldThrowException() {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setName("Category Test");

        Mockito.when(iCategoryPersistencePort.findCategoryByName
                (categoryModel.getName())).thenReturn(new CategoryModel());

        assertThrows(CategoryAlreadyExistsException.class,
                () -> toTest.saveCategory(categoryModel));
        verify(iCategoryPersistencePort,
                        Mockito.never())
                .saveCategory(any(CategoryModel.class));
    }


    @Test
    void givenAListWhenInvokeListCategoryThenShouldReturnTheList() {
        CategoryModel testCategory1 = new CategoryModel();
        testCategory1.setName("Category 1");

        CategoryModel testCategory2 = new CategoryModel();
        testCategory2.setName("Category 2");

        List<CategoryModel> testListCategory =
                Arrays.asList(testCategory1, testCategory2);

        Mockito.when(iCategoryPersistencePort.listCategory())
                .thenReturn(testListCategory);

        List<CategoryModel> actuallyList = toTest.listCategory();
        verify(iCategoryPersistencePort,
                times(1)).listCategory();

        assertEquals(testListCategory, actuallyList);
    }
}