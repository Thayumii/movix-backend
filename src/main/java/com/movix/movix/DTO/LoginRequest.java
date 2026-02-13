package com.movix.movix.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

}