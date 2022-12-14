package com.cs491.languageapp.entity.request;

import lombok.Data;

@Data
public class TotalSuccessOfOccupantRequest {

    private double a1Level;

    private double a2Level;

    private double b1Level;

    private double b2Level;

    private int occupantId;
}
