package com.cs491.languageapp.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mean;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="word")
    private Img img;
    @Enumerated(EnumType.STRING) // Enumdaki şeyleri string olarak al diyor
    private Level level;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY,mappedBy = "word")
    private List<OccupantSuccess> occupantSuccesses;


    public Word(String name, String mean, Level level) {
        this.name = name;
        this.mean = mean;
        this.level = level;
    }
}
