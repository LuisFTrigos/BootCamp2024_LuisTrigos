package com.example.emazon_aux.infrastructure.configuration.security.service;

import com.example.emazon_aux.infrastructure.configuration.security.dto.AuthCredentials;
import com.example.emazon_aux.infrastructure.configuration.security.util.TokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserDetailsService userDetailsService;

    public String login(AuthCredentials authCredentials) {
        //load user from database.
        UserDetails userDetails = userDetailsService.loadUserByUsername(authCredentials.getEmail());
        return TokenUtils.createToken(userDetails);

    }
}
