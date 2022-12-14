package com.cs491.languageapp.controller;


import com.cs491.languageapp.entity.request.CreateOccupantSuccessRequest;
import com.cs491.languageapp.entity.response.CreateOccupantSuccessResponse;
import com.cs491.languageapp.service.OccupantSuccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<CreateOccupantSuccessResponse> create(@Valid @RequestBody CreateOccupantSuccessRequest request){
        return new ResponseEntity<>(occupantSuccessService.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Map<String,Integer>> getOccupantSuccessByLevel(@Valid @RequestParam int occupantId, @RequestParam String level){
        return new ResponseEntity<>(occupantSuccessService.getOccupantSuccessByLevel(occupantId,level),HttpStatus.OK);
    }

    @GetMapping("/correct-number-in-a-week")
    public ResponseEntity<Integer> correctNumberInAWeek(@Valid @RequestParam int occupantId){
        return new ResponseEntity<>(occupantSuccessService.correctNumberInAWeek(occupantId),HttpStatus.OK);
    }
    @GetMapping("/false-number-in-a-week")
    public ResponseEntity<Integer> falseNumberInAWeek(@Valid @RequestParam int occupantId){
        return new ResponseEntity<>(occupantSuccessService.falseNumberInAWeek(occupantId),HttpStatus.OK);
    }
}
