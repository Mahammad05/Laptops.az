package com.mahammad.laptops_az.service.security;

import com.mahammad.laptops_az.dto.auth.AuthRegisterRequest;
import com.mahammad.laptops_az.exception.ApplicationException;
import com.mahammad.laptops_az.exception.ExceptionEnum;
import com.mahammad.laptops_az.model.User;
import com.mahammad.laptops_az.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void register(AuthRegisterRequest request) {

        // Check for duplicate username
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new ApplicationException(ExceptionEnum.DUPLICATE_EMAIL_OR_USERNAME_EXCEPTION);
        }

        // Check for duplicate email
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ApplicationException(ExceptionEnum.DUPLICATE_EMAIL_OR_USERNAME_EXCEPTION);
        }

        // Map the user
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);
    }
}
