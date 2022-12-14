package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.Img;
import com.cs491.languageapp.entity.response.ImageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageConverter {

    public ImageResponse converter(Img from){
        if(from==null){
            return null;
        }
        return new ImageResponse(from.getId(),from.getUrl());
    }

    public List<ImageResponse> converter(List<Img> fromList){
        if(fromList==null){
            return null;
        }
        return fromList.stream().map(image -> new ImageResponse(image.getId(), image.getUrl())).collect(Collectors.toList());
    }
}
