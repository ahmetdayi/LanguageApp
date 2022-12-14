package com.cs491.languageapp.entity.request;

import com.cs491.languageapp.core.validator.ValidPassword;
import com.cs491.languageapp.core.validator.update.UpdatePasswordMatches;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@UpdatePasswordMatches(message ="Password dont match")
public class UpdateOccupantRequest {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    @ValidPassword
    @NotBlank
    private String password;

    @NotBlank
    private String matchingPassword;
}
