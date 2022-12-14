package com.cs491.languageapp.entity.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class CreateWordRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String mean;

    @NotBlank
    private String level;
}
