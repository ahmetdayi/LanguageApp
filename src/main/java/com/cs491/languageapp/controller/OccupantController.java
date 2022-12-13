package com.cs491.languageapp.controller;

import com.cs491.languageapp.entity.request.CreateOccupantRequest;
import com.cs491.languageapp.entity.response.CreateOccupantResponse;
import com.cs491.languageapp.entity.response.OccupantResponse;
import com.cs491.languageapp.service.OccupantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/occupant")
public class OccupantController {
    private final OccupantService occupantService;

    @PostMapping
    public ResponseEntity<CreateOccupantResponse> create(@RequestBody CreateOccupantRequest request){

        return new ResponseEntity<>(occupantService.create(request), HttpStatus.CREATED); // web dili http ile yazıldığı için response entity olarak dönmemiz gerekiyor cunku httpnin oluşturulmasını sağlayan şey response entity methodu
    }
    @GetMapping
    public ResponseEntity<OccupantResponse> getById(@RequestParam int id){
        return new ResponseEntity<>(occupantService.getById(id),HttpStatus.OK);


    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id ){
        occupantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
