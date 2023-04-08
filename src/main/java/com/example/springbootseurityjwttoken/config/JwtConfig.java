package com.example.springbootseurityjwttoken.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {
    private String secretKey;
    private String tokenPrefix;
    private Long expirationDateAfterDays;

    public void setTokenExpirationAfterDays(Long tokenExpirationAfterDays) {
        this.expirationDateAfterDays = tokenExpirationAfterDays * 6500000;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}