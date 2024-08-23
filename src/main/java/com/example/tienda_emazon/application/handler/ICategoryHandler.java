package com.example.tienda_emazon.application.handler;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import java.util.List;

public interface ICategoryHandler {

    void saveCategoryList(CategoryRequestDto categoryRequestDto);

    List<GenericResponse> getAllCategoriesList();


}
