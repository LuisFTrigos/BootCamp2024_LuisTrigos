package com.example.tienda_emazon.application.service;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;

public interface ICategoryService {
    //Especificar los métodos que se comunican entre el controlador y el dominio
    GenericResponse saveCategory(CategoryRequestDto requestDto);

}
