package com.example.emazon_aux.infrastructure.input;


import com.example.emazon_aux.aplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/Form")
    public ResponseEntity<Map<String,String>> saveUser(){
        return ResponseEntity.ok(userService.getForm());
    }
}
