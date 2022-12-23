package com.cs491.languageapp.repostory;

import com.cs491.languageapp.entity.Img;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<Img,Integer> {
}
