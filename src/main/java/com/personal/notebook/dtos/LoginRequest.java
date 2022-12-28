package com.personal.notebook.dtos;
import lombok.Data;

@Data
public class LoginRequest {

    private String credentials;
    private String password;
}
