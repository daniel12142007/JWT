package com.example.springbootseurityjwttoken.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    STUDENT,
    TEACHER,
    MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }
}