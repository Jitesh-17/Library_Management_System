package com.jitesh.library_api.service;


import com.jitesh.library_api.model.User;

public interface JwtService {
    String generateToken(User user);
    
}
