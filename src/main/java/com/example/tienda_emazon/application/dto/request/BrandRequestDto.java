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
public class BrandRequestDto {

    @Min(value = 6, message = "El nombre de marca debe tener más de 6 carácteres")
    @Max(value = 50, message = "El nombre de marca debe tener menos de 50 carácteres")
    @NotBlank(message = "El nombre de marca no puede estar vacío")
    private String name;
    @Min(value = 6, message = "La descripción de marca debe tener más de 6 carácteres")
    @Max(value = 120, message = "La descripción de marca debe tener menos de 120 carácteres")
    @NotBlank(message = "La descripción de marca no puede estar vacía")
    private String description;
}
