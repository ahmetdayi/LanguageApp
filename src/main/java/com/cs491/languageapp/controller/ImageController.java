package com.cs491.languageapp.controller;

import com.cs491.languageapp.entity.response.ImageResponse;
import com.cs491.languageapp.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequestMapping("/image")
@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;


    @PostMapping()
    public ResponseEntity<ImageResponse> createImage(@Valid @RequestParam("file") MultipartFile multipartFile,
                                                     @Valid @RequestParam("carId") int carId) {

        return new ResponseEntity<>(imageService.addImage(multipartFile, carId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<Void> deleteImageByImageId(@PathVariable int imageId) {
        imageService.deleteImageByImageId(imageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}