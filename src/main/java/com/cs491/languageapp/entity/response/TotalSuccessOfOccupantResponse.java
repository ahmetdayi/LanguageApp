package com.cs491.languageapp.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalSuccessOfOccupantResponse {

    private int id;

    private double a1Level;

    private double a2Level;

    private double b1Level;

    private double b2Level;


}
