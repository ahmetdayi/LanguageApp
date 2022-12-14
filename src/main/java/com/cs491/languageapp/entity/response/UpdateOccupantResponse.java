package com.cs491.languageapp.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOccupantResponse {
    private int id;
    private String name;
    private String email;

    private String password;

    private String matchingPassword;
}
