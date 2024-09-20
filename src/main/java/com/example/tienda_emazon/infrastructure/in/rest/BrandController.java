package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.BrandRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.IBrandHandler;
import com.example.tienda_emazon.domain.model.BrandModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {
    private final IBrandHandler brandHandler;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveBrand(@RequestBody BrandRequestDto brandRequestDto){
        GenericResponse genericResponse = brandHandler.saveBrand(brandRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public ResponseEntity<CustomPage<BrandModel>> getBrands(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size,
                                                            @RequestParam(defaultValue = "asc") String sortDirection,
                                                            @RequestParam(defaultValue = "brandName") String sortBy) {

        return ResponseEntity.ok(brandHandler.getBrandsPaginated(new PageRequestDomain(page, size, sortDirection, sortBy)));
    }
}
