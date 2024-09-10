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
public class CategoryRequestDto {

    @Min(value = 6, message = "El nombre debe tener más de 6 carácteres")
    @Max(value = 50, message = "El nombre debe tener menos de 50 carácteres")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String categoryName;
    @Min(value = 6, message = "La descripción debe tener más de 6 carácteres")
    @Max(value = 90, message = "La descripción debe tener menos de 90 carácteres")
    @NotBlank(message = "La descripción no puede estar vacía")
    private String categoryDescription;
}
