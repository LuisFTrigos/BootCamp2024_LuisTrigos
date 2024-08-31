package com.example.tienda_emazon.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

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
    private String nameSupply;

    @Min(value = 5, message = "La descripción del articulo debe tener más de 5 carácteres")
    @Max(value = 100, message = "La descripción del articulo debe tener menos de 100 carácteres")
    @NotBlank(message = "El campo descripción del articulo no puede estar vacío")
    private String descriptionSupply;

    @NotBlank(message = "El campo del articulo no puede estar vacío")
    private long amountSupply;

    @NotBlank(message = "El campo del articulo no puede estar vacío")
    private long priceSupply;
}
