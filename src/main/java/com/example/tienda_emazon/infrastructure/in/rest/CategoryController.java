package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ICategoryHandler;
import com.example.tienda_emazon.application.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final ICategoryHandler categoryHandler;
    private final ICategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        GenericResponse genericResponse = categoryService.saveCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }
    @GetMapping
    public ResponseEntity<List<GenericResponse>> getAllCategoriesList() {
        return ResponseEntity.ok(categoryHandler.getAllCategoriesList());
    }
}
