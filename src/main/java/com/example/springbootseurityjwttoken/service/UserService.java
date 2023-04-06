package com.example.springbootseurityjwttoken.service;

import com.example.springbootseurityjwttoken.config.JwtUtils;
import com.example.springbootseurityjwttoken.dto.auth.AuthRequest;
import com.example.springbootseurityjwttoken.dto.auth.AuthResponse;
import com.example.springbootseurityjwttoken.dto.request.UserRequest;
import com.example.springbootseurityjwttoken.model.Role;
import com.example.springbootseurityjwttoken.model.User;
import com.example.springbootseurityjwttoken.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<String> create(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("this email is already have in!");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setFirst_name(request.getName());
        user.setRole(Role.USER);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}