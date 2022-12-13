package com.cs491.languageapp.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id nin auto increase yapması için generate value yazıyoruz. Id olduğunu anlamak için ise id olarak yazmamız gerekiyor
    private int id;
    private String url;
    @JoinColumn
    //wordun tablosuna img id yi ekledi boylelikle worddeyken img ı cağırabiliriz mesela masadan cağırırsak masa resmi gelicek
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    // cascade silme ve ekleme işlemlerini belirliyor.
//all yaptığında img silinirse word de silinir merge yaparsan sadece ilişkili sınıf silinir yada eklenir.
    private Word word;

}
