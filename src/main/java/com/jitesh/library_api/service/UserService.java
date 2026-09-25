package com.jitesh.library_api.service;
import com.jitesh.library_api.dto.LoginRequest;
import com.jitesh.library_api.dto.LoginResponse;
import com.jitesh.library_api.dto.UserRequest;
import com.jitesh.library_api.dto.UserResponse;


public interface UserService  {
    
    UserResponse registerUser(UserRequest request);
    LoginResponse loginUser(LoginRequest request);
}
