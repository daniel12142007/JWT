package com.example.springbootseurityjwttoken.dto.request;

import lombok.*;

@Setter
@Getter
public class UserRequest {
    private String name;
    private String email;
    private String password;
}