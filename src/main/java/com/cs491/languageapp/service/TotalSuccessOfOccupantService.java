package com.cs491.languageapp.service;

import com.cs491.languageapp.entity.Convertor.TotalSuccessOfOccupantConverter;
import com.cs491.languageapp.entity.Level;
import com.cs491.languageapp.entity.TotalSuccessOfOccupant;
import com.cs491.languageapp.entity.response.TotalSuccessOfOccupantResponse;
import com.cs491.languageapp.repostory.TotalSuccessOfOccupantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TotalSuccessOfOccupantService {

    private final TotalSuccessOfOccupantConverter successOfOccupantConverter;

    private final TotalSuccessOfOccupantRepository totalSuccessOfOccupantRepository;


    public void create(TotalSuccessOfOccupant request) {

        TotalSuccessOfOccupant successOfOccupant = new TotalSuccessOfOccupant
                (
                        request.getA1Level(),
                        request.getA2Level(),
                        request.getB1Level(),
                        request.getB2Level(),
                        request.getOccupant()
                );
        successOfOccupantConverter.convert(totalSuccessOfOccupantRepository.save(successOfOccupant));
    }

    public void update(int occupantId, Level level) {
        TotalSuccessOfOccupant
                successOfOccupant = totalSuccessOfOccupantRepository
                .findByOccupant_Id(occupantId);

        if(level.toString().equals("A1")){
            successOfOccupant.setA1Level(successOfOccupant.getA1Level() +1);
        } else if (level.toString().equals("A2")) {
            successOfOccupant.setA2Level(successOfOccupant.getA2Level() + 1);
        } else if (level.toString().equals("B1")) {
            successOfOccupant.setB1Level(successOfOccupant.getB1Level() +1);
        } else if (level.toString().equals("B2")) {
            successOfOccupant.setB1Level(successOfOccupant.getB1Level() +1);
        }
        else{
            //TODO hata don
        }
        successOfOccupantConverter.convert(totalSuccessOfOccupantRepository.save(successOfOccupant));
    }

    public TotalSuccessOfOccupantResponse getByOccupant_Id(int occupantId){
        return successOfOccupantConverter.convert(totalSuccessOfOccupantRepository.findByOccupant_Id(occupantId));
    }
}
