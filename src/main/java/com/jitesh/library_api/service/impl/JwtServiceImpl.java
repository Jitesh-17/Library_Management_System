package com.jitesh.library_api.service.impl;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jitesh.library_api.model.User;
import com.jitesh.library_api.service.JwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.service}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
    
    @Override
    public String generateToken(User user){

        SecretKey key = Keys.hmacShaKeyFor(
            secret.getBytes(StandardCharsets.UTF_8)
        );


        return Jwts.builder() // starts creating the token
                .subject(user.getUserName()) // stores the username
                .claim("role",user.getRole()) // stroes extrainfo like userdetails
                .issuedAt(new Date()) //token creation timestamp
                .expiration(new Date(System.currentTimeMillis()+expiration)) // token expiration time
                .signWith(key) //sign the token with our secreat key
                .compact();     // produces the final jwt string 
    }
}
