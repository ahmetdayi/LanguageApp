package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.response.CreateWordResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordConverter {

    public CreateWordResponse convert(Word word){

        CreateWordResponse convertWordResponse=new CreateWordResponse(word.getId(),word.getName(),word.getName(),word.getImg(),word.getLevel());
        return convertWordResponse;
    }
    public List<WordResponse> convertWordResponse(List<Word> word){

        List<WordResponse> collect = word.stream().map(word1 -> new WordResponse(word1.getId(), word1.getName(), word1.getMean(), word1.getImg())).collect(Collectors.toList());
        return collect;
    }
    public WordResponse convertWordResponse(Word word){
        if (word ==null){
            return null;
        }
        WordResponse wordResponse = new WordResponse(word.getId(), word.getName(),word.getMean(),word.getImg());
        return wordResponse;
    }


}
