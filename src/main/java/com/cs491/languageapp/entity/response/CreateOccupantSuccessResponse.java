package com.cs491.languageapp.entity.response;

import com.cs491.languageapp.entity.Word;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateOccupantSuccessResponse {
    private int id;
    private boolean isTrue;
    private LocalDateTime localDateTime;

    private WordResponse word;

    private OccupantResponse occupant;
}
