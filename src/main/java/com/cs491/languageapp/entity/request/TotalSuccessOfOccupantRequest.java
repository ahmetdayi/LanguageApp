package com.cs491.languageapp.entity.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TotalSuccessOfOccupantRequest {

    @NotNull
    private double a1Level;

    @NotNull
    private double a2Level;

    @NotNull
    private double b1Level;

    @NotNull
    private double b2Level;

    @NotNull
    private int occupantId;
}
