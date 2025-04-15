package com.mahammad.laptops_az.dto.auth;

import lombok.Data;

@Data
public class AuthRegisterRequest {
    private String username;
    private String email;
    private String password;
}
