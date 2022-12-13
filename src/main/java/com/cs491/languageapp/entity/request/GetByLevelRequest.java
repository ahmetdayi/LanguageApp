package com.cs491.languageapp.entity.request;

import lombok.Data;

@Data
public class GetByLevelRequest {
    private int page ;
    private int size;
    private String level;
}
