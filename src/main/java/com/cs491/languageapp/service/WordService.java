package com.cs491.languageapp.service;

import com.cs491.languageapp.entity.Convertor.LevelConverter;
import com.cs491.languageapp.entity.Convertor.WordConverter;
import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.request.CreateWordRequest;
import com.cs491.languageapp.entity.request.GetByLevelRequest;
import com.cs491.languageapp.entity.response.CreateWordResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import com.cs491.languageapp.repostory.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // service oldugu belli olsun word servesi newliyor
@RequiredArgsConstructor // private final diye tanımladığımız classların başka classlarda çalıştırılmasına olanak sağlayan annotation
public class WordService {

    private final WordRepository wordRepository;
    private final WordConverter wordConverter;
    private final LevelConverter levelConverter;
    public List<Word> getAll(){ // get all methodu böyle yapılıyor

        return wordRepository.findAll();
    }


    public CreateWordResponse create(CreateWordRequest request){

        Word word=new Word(request.getName(),request.getMean(),levelConverter.convert(request.getLevel()));

        Word save = wordRepository.save(word);
        return wordConverter.convert(save);// dışarıdan cağırdığımız methodun içine userrepository.save alıp direkt database kaydedebiliyoruz
    }
    public List<WordResponse> getByLevelPageable(GetByLevelRequest request){
        Pageable pageable = PageRequest.of(request.getPage()-1, request.getSize());
        List<Word> byLevelA1 = wordRepository.findByLevel(levelConverter.convert(request.getLevel()),pageable);//pageable olusturup kacıncı sayfayı gosterecegımızı ve bır sayfada kac kelıme gosterilecegini belırtıyoruz.
        return wordConverter.convertWordResponse(byLevelA1);
    }

    protected List<WordResponse> getByLevel(String level){
        return wordConverter.convertWordResponse(wordRepository.findByLevel(levelConverter.convert(level)));
    }

    protected Word getById(int id){
        return wordRepository.findById(id);
    }


}
