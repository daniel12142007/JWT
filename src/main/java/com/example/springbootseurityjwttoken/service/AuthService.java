package com.example.springbootseurityjwttoken.service;

import com.example.springbootseurityjwttoken.config.JwtUtils;
import com.example.springbootseurityjwttoken.dto.auth.AuthRequest;
import com.example.springbootseurityjwttoken.dto.auth.AuthResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authenticate;
        authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));
        String generateToken = jwtUtils.generateToken(authenticate);
        System.out.println(generateToken);
        return new AuthResponse(authRequest.getEmail(), generateToken);
    }
}