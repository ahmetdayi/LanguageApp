package com.cs491.languageapp.entity.Convertor;


import com.cs491.languageapp.entity.response.QuestionResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import com.cs491.languageapp.entity.response.WordsResponseWithoutImg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionConverter {

    private final ImageConverter imageConverter;


    public QuestionResponse convert(List<WordsResponseWithoutImg> fromList, WordResponse wordResponse) {
        return new QuestionResponse(
                wordResponse.getImg(),
                fromList,
                wordResponse.getName()
        );
    }
}
