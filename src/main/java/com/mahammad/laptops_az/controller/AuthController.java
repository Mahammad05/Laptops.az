package com.mahammad.laptops_az.controller;

import com.mahammad.laptops_az.dto.auth.AuthRegisterRequest;
import com.mahammad.laptops_az.model.response.ServiceResponse;
import com.mahammad.laptops_az.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ServiceResponse<?> register(@RequestBody AuthRegisterRequest request) {
        authService.register(request);
        return ServiceResponse.success("User created successfuly");
    }
}
