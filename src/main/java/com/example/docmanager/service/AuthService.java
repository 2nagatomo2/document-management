package com.example.docmanager.service;

import com.example.docmanager.config.JwtUtil;
import com.example.docmanager.dao.UserDao;
import com.example.docmanager.dto.*;
import com.example.docmanager.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    public UserResponse registerUser(UserRegistrationRequest request) {
        logger.info("Registering new user with email: {}", request.email());

        // Check if user already exists
        if (userDao.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Error: Email is already in use!");
        }

        if (userDao.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("Error: Username is already taken!");
        }

        // Create new user
        User user = new User(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password()),
                "USER"
        );

        userDao.insert(user);

        logger.info("User registered successfully with email: {}", request.email());

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        logger.info("Authenticating user with email: {}", loginRequest.email());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.email(),
                            loginRequest.password()
                    )
            );

            String jwt = jwtUtil.generateJwtToken(loginRequest.email());
            logger.info("User authenticated successfully with email: {}", loginRequest.email());

            return new JwtResponse(jwt);
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", loginRequest.email());
            throw new RuntimeException("Invalid email or password");
        }
    }

    public UserResponse getCurrentUser(String email) {
        logger.info("Getting current user info for email: {}", email);

        Optional<User> userOptional = userDao.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}