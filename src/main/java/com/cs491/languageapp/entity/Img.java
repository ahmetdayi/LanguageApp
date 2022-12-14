package com.cs491.languageapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id nin auto increase yapması için generate value yazıyoruz. Id olduğunu anlamak için ise id olarak yazmamız gerekiyor
    private int id;
    private String url;
    //wordun tablosuna img id yi ekledi boylelikle worddeyken img ı cağırabiliriz mesela masadan cağırırsak masa resmi gelicek
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    // cascade silme ve ekleme işlemlerini belirliyor.
//all yaptığında img silinirse word de silinir merge yaparsan sadece ilişkili sınıf silinir yada eklenir.
    private Word word;

    public Img(String url, Word word) {
        this.url = url;
        this.word = word;
    }
}
