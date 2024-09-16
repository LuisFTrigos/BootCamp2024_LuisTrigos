package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.handler.ISupplyHandler;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.page.CustomPage;
import com.example.tienda_emazon.domain.model.page.PageRequestDomain;
import com.example.tienda_emazon.infrastructure.out.entity.SupplyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supply")
public class SupplyController {

    private final ISupplyHandler supplyHandler;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveSupply(@RequestBody SupplyRequestDto supplyRequestDto){
        GenericResponse genericResponse = supplyHandler.saveSupply(supplyRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public ResponseEntity<CustomPage<SupplyModel>> getBrands(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size,
                                                             @RequestParam(defaultValue = "asc") String sortDirection,
                                                             @RequestParam(defaultValue = "supplyName") String sortBy){
        return ResponseEntity.ok(supplyHandler.getSuppliesPaginated(new PageRequestDomain(page, size, sortDirection, sortBy)));
    }

}
