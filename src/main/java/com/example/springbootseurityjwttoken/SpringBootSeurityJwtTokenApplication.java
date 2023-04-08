package com.example.springbootseurityjwttoken;

import com.example.springbootseurityjwttoken.model.*;
import com.example.springbootseurityjwttoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootSeurityJwtTokenApplication {
    private final UserRepository userRepository;
    private final PasswordEncoder pasl;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSeurityJwtTokenApplication.class, args);
        System.out.println("Hello World!");
    }
    @PostConstruct
    public void init(){
        User user = new User();
        user.setFirst_name( "Daniel" );
        user.setEmail( "daniel@gmail.com" );
        user.setRole( Role.ADMIN );
        user.setPassword( pasl.encode( "daniel" ) );

        User user1 = new User();
        user1.setFirst_name( "Marlen" );
        user1.setEmail( "marlen@gmail.com" );
        user1.setRole( Role.MANAGER);
        user1.setPassword( pasl.encode( "marlen" ) );

        userRepository.save( user1 );
        userRepository.save( user );
    }
}