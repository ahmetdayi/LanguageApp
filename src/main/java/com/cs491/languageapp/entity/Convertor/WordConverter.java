package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.response.CreateWordResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WordConverter {

    public CreateWordResponse convert(Word word) {

        return new CreateWordResponse(word.getId(), word.getName(), word.getName(), word.getImg(), word.getLevel());
    }

    public List<WordResponse> convertWordResponse(List<Word> word) {

        if(word == null){
            return null;
        }

        return word.stream()
                .map(word1 -> new WordResponse
                        (
                                word1.getId(),
                                word1.getName(),
                                word1.getMean(),
                                word1.getImg())
                )
                .collect(Collectors.toList());
    }

    public WordResponse convertWordResponse(Word word) {
        if (word == null) {
            return null;
        }
        return new WordResponse(word.getId(), word.getName(), word.getMean(), word.getImg());
    }


}
