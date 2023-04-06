package com.example.springbootseurityjwttoken.api;

import com.example.springbootseurityjwttoken.dto.auth.AuthRequest;
import com.example.springbootseurityjwttoken.dto.auth.AuthResponse;
import com.example.springbootseurityjwttoken.dto.request.UserRequest;
import com.example.springbootseurityjwttoken.service.AuthService;
import com.example.springbootseurityjwttoken.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequiredArgsConstructor
public class Api {
    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    @PermitAll
    public ResponseEntity<String> create(@RequestBody UserRequest userRequest) {
        userService.create(userRequest);
        return ResponseEntity.ok().body("user with name:" + userRequest.getName() + " successfully save");
    }

    @PostMapping("/login")
    @PermitAll
    public AuthResponse authenticated(@RequestBody AuthRequest requestBody) {
        return authService.authenticate(requestBody);
    }

    @GetMapping("/getUser")
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    public String getString() {
        return "I'm User";
    }

    @GetMapping("/getAdmin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getAdmin() {
        return "I'm Admin";
    }
}