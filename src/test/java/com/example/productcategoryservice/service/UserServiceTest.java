package com.example.productcategoryservice.service;

import com.example.productcategoryservice.entity.Role;
import com.example.productcategoryservice.entity.User;
import com.example.productcategoryservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void findByEmail() {
        User user = User.builder()
                .id(1)
                .name("poxos")
                .surname("poxosyan")
                .email("poxos@mail.com")
                .password("poxos")
                .role(Role.USER)
                .build();
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        userService.findByEmail(user.getEmail());
        verify(userRepository, times(1)).findByEmail(any());
    }

    @Test
    void findByEmailNull() {
        User user = User.builder()
                .id(1)
                .name("poxos")
                .surname("poxosyan")
                .email("poxos@mail.com")
                .password("poxos")
                .role(Role.USER)
                .build();
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        assertThrows(RuntimeException.class, () -> {
            userService.findByEmail(null);
        });
        verify(userRepository, times(0)).findByEmail(any());
    }

    @Test
    void save() {
        User user = User.builder()
                .id(1)
                .name("poxos")
                .surname("poxosyan")
                .email("poxos@mail.com")
                .password("poxos")
                .role(Role.USER)
                .build();
        when(userRepository.save(any())).thenReturn(user);
        userService.save(User.builder()
                .name("poxos")
                .surname("poxosyan")
                .email("poxos@mail.com")
                .password("poxos")
                .role(Role.USER)
                .build());
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void saveNull() {
        User user = User.builder()
                .id(1)
                .name("poxos")
                .surname("poxosyan")
                .email("poxos@mail.com")
                .password("poxos")
                .role(Role.USER)
                .build();
        when(userRepository.save(any())).thenReturn(user);
        assertThrows(RuntimeException.class, () -> {
            userService.save(null);
        });
        verify(userRepository, times(0)).save(any());
    }
}