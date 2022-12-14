package com.cs491.languageapp.service;

import com.cs491.languageapp.core.exception.PasswordDoesntMatchEmailException;
import com.cs491.languageapp.core.exception.constant.Constant;
import com.cs491.languageapp.entity.Convertor.OccupantConverter;
import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.request.LoginRequest;
import com.cs491.languageapp.entity.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final OccupantService occupantService;
    private final OccupantConverter occupantConverter;


    public LoginResponse login(LoginRequest request){
        Occupant occupant = occupantService.findByEmail(request.getEmail());
        if (occupant.getPassword().equals(request.getPassword())){
            return new LoginResponse(occupantConverter.convertOccupantResponse(occupant));
        }
        else{
           throw new PasswordDoesntMatchEmailException(Constant.PASSWORD_DOESNT_MATCH_EMAIL);
        }

    }
}
