package com.example.emazon_aux.infrastructure.input;


import com.example.emazon_aux.aplication.dto.request.UserRequestDto;
import com.example.emazon_aux.aplication.dto.response.GenericResponse;
import com.example.emazon_aux.aplication.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @PostMapping("/create")
    public ResponseEntity<GenericResponse> saveCategory(@RequestBody UserRequestDto userRequestDto){
        GenericResponse genericResponse = userHandler.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(genericResponse);
    }
}
