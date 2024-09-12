package com.example.tienda_emazon.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SupplyRequestDto {

    @Min(value = 2, message = "El nombre del articulo debe tener más de 2 carácteres")
    @Max(value = 50, message = "El nombre del articulo debe tener menos de 50 carácteres")
    @NotBlank(message = "El campo nombre del articulo no puede estar vacío")
    private String supplyName;

    @Min(value = 5, message = "La descripción del articulo debe tener más de 5 carácteres")
    @Max(value = 100, message = "La descripción del articulo debe tener menos de 100 carácteres")
    @NotBlank(message = "El campo descripción del articulo no puede estar vacío")
    private String supplyDescription;

    @NotBlank(message = "El campo del articulo no puede estar vacío")
    private long supplyAmount;

    @NotBlank(message = "El campo del articulo no puede estar vacío")
    private long supplyPrice;

    private List<String> associatedCategories;
}
