package com.cs491.languageapp.entity.request;

import lombok.Data;
import javax.validation.constraints.NotNull;


@Data
public class CreateOccupantSuccessRequest {

    private boolean isTrue;

    @NotNull
    private int wordId;

    @NotNull
    private int occupantId;
}
