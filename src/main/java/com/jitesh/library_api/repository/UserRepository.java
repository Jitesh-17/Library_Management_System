package com.jitesh.library_api.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitesh.library_api.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
    Optional<User> findByUserName(String username);
    Optional<User> findByEmail(String email);

}
