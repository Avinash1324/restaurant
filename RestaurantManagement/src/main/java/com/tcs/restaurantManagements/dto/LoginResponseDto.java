package com.tcs.restaurantManagements.dto;

public class LoginResponseDto {
    private String username;
    private String email;
    private String role;

    public LoginResponseDto(String username, String email, String role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }

    // Getters (no need for setters if you don’t plan to modify)
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
