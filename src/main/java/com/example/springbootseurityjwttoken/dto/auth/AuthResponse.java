package com.example.springbootseurityjwttoken.dto.auth;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private String jwt;
}