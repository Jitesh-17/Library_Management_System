package com.jitesh.library_api.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jitesh.library_api.dto.LoginRequest;
import com.jitesh.library_api.dto.UserRequest;
import com.jitesh.library_api.dto.UserResponse;
import com.jitesh.library_api.exception.UserAlreadyExistsException;
import com.jitesh.library_api.model.User;
import com.jitesh.library_api.repository.UserRepository;
import com.jitesh.library_api.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;

@Service 
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override 
    public UserResponse registerUser(UserRequest request){

        if(userRepository.findByUserName(request.getUsername()).isPresent()){
            throw new UserAlreadyExistsException("UserName Already exists");
        }
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new UserAlreadyExistsException("Email Already exists");
        }
        User user = new User();

        user.setUserName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        User savedUser = userRepository.save(user);

        return new UserResponse(
            savedUser.getId(),savedUser.getUserName(),
            savedUser.getEmail(),savedUser.getRole()
        );
    }

    @Override 
    public UserResponse loginUser(LoginRequest request){
        User user = findUserByIdentifier(request.getIdentifier());

        if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

            throw new BadCredentialsException("Invalid username/email or password");
        }

        return new UserResponse(
        user.getId(),
        user.getUserName(),
        user.getEmail(),
        user.getRole()
        );

    }

    //helper method for login user
    private User findUserByIdentifier(String identifier){

        if(identifier.contains("@")){
            return userRepository.findByEmail(identifier)
                    .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        }

        return userRepository.findByUserName(identifier)
                .orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
    }
}
