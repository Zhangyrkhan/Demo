package com.example.demo.dto;

import com.example.demo.utills.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
    private Role role;
}
