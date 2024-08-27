package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.service.IBrandService;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.PageableQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {
    private final IBrandService brandService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveBrand
            (@RequestBody BrandRequestDto brandRequestDto){
        GenericResponse genericResponse = brandService.saveBrand(brandRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public Page<BrandModel> getAll(PageableQuery pageableQuery){
        return brandService.getAll(pageableQuery);
    }
}
