package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByEmail(String username) {
        if (username == null){
            throw new RuntimeException("username can't be null");
        }
        return userRepository.findByEmail(username);
    }

    public User save(User user) {
        if (user == null){
            throw new RuntimeException("user can't be null");
        }
        return userRepository.save(user);
    }
}
