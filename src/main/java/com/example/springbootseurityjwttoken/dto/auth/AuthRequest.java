package com.example.springbootseurityjwttoken.dto.auth;


import lombok.*;

@Setter
@Getter
public class AuthRequest {
    private String email;
    private String password;
}