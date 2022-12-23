package com.cs491.languageapp.service;

import com.cs491.languageapp.core.exception.LevelNullException;
import com.cs491.languageapp.core.exception.TotalSuccessOfOccupantDoesntExistYetException;
import com.cs491.languageapp.core.exception.WrongLevelSelectedException;
import com.cs491.languageapp.core.exception.constant.Constant;
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
        successOfOccupantConverter.convert(totalSuccessOfOccupantRepository.save(request));
    }

    public void update(int occupantId, Level level) {
        TotalSuccessOfOccupant
                successOfOccupant = findByOccupant_Id(occupantId);
        if(level==null){
            throw new LevelNullException(Constant.LEVEL_IS_NULL);
        }

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
            throw new WrongLevelSelectedException(Constant.WRONG_LEVEL_SELECTED);
        }
        successOfOccupantConverter.convert(totalSuccessOfOccupantRepository.save(successOfOccupant));
    }

    public TotalSuccessOfOccupantResponse getByOccupant_Id(int occupantId){
        return successOfOccupantConverter.convert(findByOccupant_Id(occupantId));
    }

    protected TotalSuccessOfOccupant findByOccupant_Id(int occupantId){
        return totalSuccessOfOccupantRepository
                .findByOccupant_Id(occupantId).orElseThrow(
                        ()->new TotalSuccessOfOccupantDoesntExistYetException
                                (Constant.TOTAL_SUCCESS_OF_OCCUPANT_DOESNT_EXIST_YET));
    }
}
