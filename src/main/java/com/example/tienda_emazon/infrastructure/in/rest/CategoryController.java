package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.service.ICategoryService;
import com.example.tienda_emazon.domain.model.CategoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        GenericResponse genericResponse = categoryService.saveCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllCategoriesList() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}

