package com.cs491.languageapp.entity.response;

import com.cs491.languageapp.entity.Img;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {

    private ImageResponse img;
    private List<WordResponse> words;

    private String correctWord;
}
