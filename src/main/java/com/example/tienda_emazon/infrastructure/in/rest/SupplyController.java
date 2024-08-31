package com.example.tienda_emazon.infrastructure.in.rest;

import com.example.tienda_emazon.application.dto.request.SupplyRequestDto;
import com.example.tienda_emazon.application.dto.response.GenericResponse;
import com.example.tienda_emazon.application.service.ISupplyService;
import com.example.tienda_emazon.domain.model.SupplyModel;
import com.example.tienda_emazon.domain.model.query.PageableQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supply")
public class SupplyController {

    private final ISupplyService iSupplyService;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveSupply
            (@RequestBody SupplyRequestDto supplyRequestDto){
        GenericResponse genericResponse = iSupplyService.saveSupply(supplyRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }

    @GetMapping
    public Page<SupplyModel> getAll(PageableQuery pageableQuery){
        return iSupplyService.getAllPages(pageableQuery);
    }
}
