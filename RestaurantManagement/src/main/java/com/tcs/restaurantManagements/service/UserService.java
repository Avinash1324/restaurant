package com.tcs.restaurantManagements.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.restaurantManagements.dto.LoginDto;
import com.tcs.restaurantManagements.dto.LoginResponseDto;
import com.tcs.restaurantManagements.dto.UserRegistrationDto;
import com.tcs.restaurantManagements.model.User;
import com.tcs.restaurantManagements.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
    private UserRepository userRepository;

    // Register Staff
    public User registerUser(UserRegistrationDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered!");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // ⚠ plain text
        user.setRole("STAFF"); 

        return userRepository.save(user);
    }

    // Login (returns DTO instead of User)
    public LoginResponseDto loginUser(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!user.getPassword().equals(loginDto.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        return new LoginResponseDto(user.getUsername(), user.getEmail(), user.getRole());
    }
}
