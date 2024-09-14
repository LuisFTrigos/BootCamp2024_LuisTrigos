package com.example.emazon_aux.aplication.dto.request;


import com.example.emazon_aux.infrastructure.output.entity.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotNull(message = "The field name cannot null")
    @NotEmpty(message = "The field name cannot empty")
    private String name;

    @NotNull(message = "The field last name cannot null")
    @NotEmpty(message = "The field last name cannot empty")
    private String lastName;

    @NotNull(message = "The field document cannot null")
    @NotEmpty(message = "The field document cannot empty")
    private int document;

    @NotNull(message = "The field phone cannot null")
    @NotEmpty(message = "The field phone cannot empty")
    private String phone;

    @Email(message = "The email format is invalid")
    @NotNull(message = "The field email cannot null")
    @NotEmpty(message = "The field email cannot empty")
    private String email;

    @NotNull(message = "The field password cannot null")
    @NotEmpty(message = "The field password cannot empty")
    private String password;

    private RoleEntity idRole;
}
