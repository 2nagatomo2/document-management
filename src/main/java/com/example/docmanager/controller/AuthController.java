package com.example.docmanager.controller;

import com.example.docmanager.dto.*;
import com.example.docmanager.service.AuthService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationRequest signUpRequest) {
        logger.info("Registration request received for email: {}", signUpRequest.email());

        try {
            UserResponse userResponse = authService.registerUser(signUpRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
        } catch (RuntimeException e) {
            logger.error("Registration failed: {}", e.getMessage());
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Bad Request", e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        logger.info("Login request received for email: {}", loginRequest.email());

        try {
            JwtResponse jwtResponse = authService.authenticateUser(loginRequest);
            return ResponseEntity.ok(jwtResponse);
        } catch (RuntimeException e) {
            logger.error("Login failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Unauthorized", e.getMessage()));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        logger.info("Current user info requested for: {}", userDetails.getUsername());

        try {
            UserResponse userResponse = authService.getCurrentUser(userDetails.getUsername());
            return ResponseEntity.ok(userResponse);
        } catch (RuntimeException e) {
            logger.error("Failed to get current user: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("Not Found", e.getMessage()));
        }
    }
}