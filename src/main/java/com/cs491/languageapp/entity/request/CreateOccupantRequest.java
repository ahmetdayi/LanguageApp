package com.cs491.languageapp.entity.request;

import lombok.Data;

@Data
public class CreateOccupantRequest {
    private String name;
    private String email;
    private String password;
}
