package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.CategoryRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ICategoryHandler;
import com.example.tienda_emazon.domain.model.CategoryModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private final ICategoryHandler categoryHandler;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        GenericResponse genericResponse = categoryHandler.saveCategory(categoryRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public ResponseEntity<CustomPage<CategoryModel>> getAllCategoriesList(@RequestParam(defaultValue = "0") int page,
                                                                          @RequestParam(defaultValue = "10") int size,
                                                                          @RequestParam(defaultValue = "asc") String sortDirection,
                                                                          @RequestParam(defaultValue = "categoryName") String sortBy) {

        return ResponseEntity.ok(categoryHandler.getCategoriesPaginated(new PageRequestDomain(page, size, sortDirection, sortBy)));
    }

}

