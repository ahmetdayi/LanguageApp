package com.cs491.languageapp.controller;


import com.cs491.languageapp.entity.response.TotalSuccessOfOccupantResponse;
import com.cs491.languageapp.service.TotalSuccessOfOccupantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/total-success-occupant")
public class TotalSuccessOfOccupantController {

    private final TotalSuccessOfOccupantService successOfOccupantService;

    @GetMapping
    public ResponseEntity<TotalSuccessOfOccupantResponse> getByOccupant_Id(@Valid @RequestParam int occupantId){
        return new ResponseEntity<>(successOfOccupantService.getByOccupant_Id(occupantId), HttpStatus.OK);
    }

    //TODO kullanıcı bugun gırdı mı nasıl yapılacak coz
}
