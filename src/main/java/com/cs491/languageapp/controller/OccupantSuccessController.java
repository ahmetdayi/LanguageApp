package com.cs491.languageapp.controller;


import com.cs491.languageapp.entity.OccupantSuccess;
import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.request.CreateOccupantSuccessRequest;
import com.cs491.languageapp.entity.response.CreateOccupantSuccessResponse;
import com.cs491.languageapp.service.OccupantService;
import com.cs491.languageapp.service.OccupantSuccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/occupant-success")
public class OccupantSuccessController {

    private final OccupantSuccessService occupantSuccessService;


    @GetMapping("/getAll")
    public ResponseEntity<List<CreateOccupantSuccessResponse>> getAll(){
        return new ResponseEntity<>(occupantSuccessService.getAll(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateOccupantSuccessResponse> create(@RequestBody CreateOccupantSuccessRequest request){
        return new ResponseEntity<>(occupantSuccessService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Map<String,Integer>> getOccupantSuccessByLevel(@RequestParam int occupantId, @RequestParam String level){
        return new ResponseEntity<>(occupantSuccessService.getOccupantSuccessByLevel(occupantId,level),HttpStatus.OK);
    }
}
