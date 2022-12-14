package com.cs491.languageapp.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {

    private int Id;

    private String url;
}
