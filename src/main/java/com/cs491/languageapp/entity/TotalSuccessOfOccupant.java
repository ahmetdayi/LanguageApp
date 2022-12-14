package com.cs491.languageapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalSuccessOfOccupant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double a1Level;

    private double a2Level;

    private double b1Level;

    private double b2Level;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn
    private Occupant occupant;

    public TotalSuccessOfOccupant(double a1Level, double a2Level, double b1Level, double b2Level, Occupant occupant) {
        this.a1Level = a1Level;
        this.a2Level = a2Level;
        this.b1Level = b1Level;
        this.b2Level = b2Level;
        this.occupant = occupant;
    }
}
