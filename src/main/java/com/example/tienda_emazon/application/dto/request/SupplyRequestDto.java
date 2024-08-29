package com.example.tienda_emazon.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyRequestDto {

    @Min(value = 1, message = "El nombre del articulo debe tener más de 1 carácteres")
    @Max(value = 50, message = "El nombre del articulo debe tener menos de 50 carácteres")
    @NotBlank(message = "El nombre del articulo no puede estar vacío")
    private String nameSupply;
    @Min(value = 6, message = "La descripción del articulo debe tener más de 6 carácteres")
    @Max(value = 100, message = "La descripción del articulo debe tener menos de 100 carácteres")
    @NotBlank(message = "La descripción del articulo no puede estar vacía")
    private String descriptionSupply;
}
