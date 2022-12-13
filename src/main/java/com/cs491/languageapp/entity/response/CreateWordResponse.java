package com.cs491.languageapp.entity.response;

import com.cs491.languageapp.entity.Img;
import com.cs491.languageapp.entity.Level;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateWordResponse {
    private int id;

    private String name;
    private String mean;
    private Img img;

    private Level level;
}
