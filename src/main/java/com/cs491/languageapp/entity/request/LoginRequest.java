package com.cs491.languageapp.entity.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}
