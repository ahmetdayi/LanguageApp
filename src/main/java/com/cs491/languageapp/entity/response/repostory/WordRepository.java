package com.cs491.languageapp.entity.response.repostory;

import com.cs491.languageapp.entity.Level;
import com.cs491.languageapp.entity.Word;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WordRepository extends JpaRepository <Word,Integer> {//generic method

    List<Word> findByLevel(Level level, Pageable pageable);//pageable getırılen degerlerı sayfa sayfa cekmene yarıyor
    List<Word> findByLevel(Level level);
    Optional<Word> findById(int id);
}
