package com.example.docmanager.dto;

public record UserResponse(
    Long id,
    String username,
    String email,
    String role
) {}