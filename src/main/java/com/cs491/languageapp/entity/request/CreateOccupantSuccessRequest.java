package com.cs491.languageapp.entity.request;

import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.response.OccupantResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import lombok.Data;


@Data
public class CreateOccupantSuccessRequest {

    private boolean isTrue;
    private int wordId;
    private int occupantId;
}
