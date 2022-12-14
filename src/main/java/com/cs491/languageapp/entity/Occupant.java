package com.cs491.languageapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data// getter setter methodlarını oluşturur
@AllArgsConstructor// bütün parametrelere sahip bir cons oluşturur
@NoArgsConstructor
@Entity

public class Occupant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    private String password;

    private String matchingPassword;

    @OneToMany(cascade =CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "occupant")
    private List<OccupantSuccess> occupantSuccesses;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "occupant")
    private TotalSuccessOfOccupant totalSuccessOfOccupant;

    public Occupant(String name, String email, String password,String matchingPassword) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.matchingPassword=matchingPassword;

    }

}
