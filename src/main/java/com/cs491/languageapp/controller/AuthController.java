package com.cs491.languageapp.controller;


import com.cs491.languageapp.entity.request.LoginRequest;
import com.cs491.languageapp.entity.response.LoginResponse;
import com.cs491.languageapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return new ResponseEntity<>(authService.login(request), HttpStatus.ACCEPTED);
    }

}
