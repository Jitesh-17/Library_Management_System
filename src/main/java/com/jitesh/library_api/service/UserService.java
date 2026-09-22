package com.jitesh.library_api.service;
import com.jitesh.library_api.dto.UserRequest;
// import com.jitesh.library_api.model.User;
import com.jitesh.library_api.dto.UserResponse;


public interface UserService  {
    
    UserResponse registerUser(UserRequest request);
}
