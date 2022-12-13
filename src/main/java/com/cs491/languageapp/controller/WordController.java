package com.cs491.languageapp.controller;

import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.request.CreateWordRequest;
import com.cs491.languageapp.entity.request.GetByLevelRequest;
import com.cs491.languageapp.entity.response.CreateWordResponse;
import com.cs491.languageapp.entity.response.WordResponse;
import com.cs491.languageapp.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word") // local host 8080ne gidip /word yazdığın zaman wordun methodları gelicek yani bu method bize wordun pathini çiziyor
public class WordController {
    private final WordService wordService;
    @GetMapping // api ile ilişki kulduğun request
    public ResponseEntity<List<Word>> getAll(){
        return new ResponseEntity<>( wordService.getAll(), HttpStatus.OK); // iki kere oluşturulmasının sebebi anlayered arcitechture
    }
   @PostMapping
    public ResponseEntity<CreateWordResponse> create(@RequestBody CreateWordRequest createWordRequest){
        return new ResponseEntity<>(wordService.create(createWordRequest),HttpStatus.CREATED);


    }
    @GetMapping("/getByLevel")
    public ResponseEntity<List<WordResponse>> getByLevelPageable(@RequestBody GetByLevelRequest request){
        return new ResponseEntity<>(wordService.getByLevelPageable(request),HttpStatus.OK);
    }

}
