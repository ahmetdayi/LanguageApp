package com.cs491.languageapp.service;

import com.cs491.languageapp.core.exception.ImageNotFoundException;
import com.cs491.languageapp.core.exception.constant.Constant;
import com.cs491.languageapp.entity.Convertor.ImageConverter;
import com.cs491.languageapp.entity.Img;
import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.response.ImageResponse;
import com.cs491.languageapp.repostory.ImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;



@Service
@RequiredArgsConstructor

public class ImageService  {

    private final ImgRepository imgRepository;

    private final WordService wordService;

    private final ImageConverter imageConverter;
    private final CloudStorageService cloudStorageService;


    protected Img getImageByImageId(int imageId){
        return imgRepository.findById(imageId).orElseThrow(() -> new ImageNotFoundException(Constant.IMAGE_NOT_FOUND));
    }



    public ImageResponse addImage(MultipartFile multipartFile, int wordId) {

        Map<?,?> upload = cloudStorageService.upload(multipartFile);
        Word word = wordService.getById(wordId);
        Img image = new Img(upload.get("url").toString(),word);
        return imageConverter.converter(imgRepository.save(image));
    }

    public void deleteImageByImageId(int imageId){
        imgRepository.deleteById(getImageByImageId(imageId).getId());
    }

}