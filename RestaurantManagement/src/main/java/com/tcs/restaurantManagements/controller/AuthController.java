package com.tcs.restaurantManagements.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tcs.restaurantManagements.dto.LoginDto;
import com.tcs.restaurantManagements.dto.LoginResponseDto;
import com.tcs.restaurantManagements.dto.UserRegistrationDto;
import com.tcs.restaurantManagements.model.User;
import com.tcs.restaurantManagements.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
    private UserService userService;

    // Register staff
//    @PostMapping("/register")
//    public User registerUser(@RequestBody UserRegistrationDto userDto) {
//        return userService.registerUser(userDto);
//    }
	@PostMapping("/register")
	public LoginResponseDto registerUser(@RequestBody UserRegistrationDto userDto) {
	    User savedUser = userService.registerUser(userDto);
	    return new LoginResponseDto(savedUser.getUsername(), savedUser.getEmail(), savedUser.getRole());
	}


    // Login (returns only username, email, role)
    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }
}
