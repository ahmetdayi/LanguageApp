package com.cs491.languageapp.config;

import com.cs491.languageapp.service.OccupantSuccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
public class StartConfig {

    private final OccupantSuccessService occupantSuccessService;


    @Bean
    private void deleteOccupantSuccessTableOnceAWeek(){
    occupantSuccessService.deleteAll();
    }
}
