package com.cs491.languageapp.entity.request;

import com.cs491.languageapp.entity.Level;
import lombok.Data;

@Data
public class CreateWordRequest {
    private String name;
    private String mean;
    private String level;
}
