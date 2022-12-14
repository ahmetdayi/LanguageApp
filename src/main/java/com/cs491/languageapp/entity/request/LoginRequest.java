package com.cs491.languageapp.entity.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
