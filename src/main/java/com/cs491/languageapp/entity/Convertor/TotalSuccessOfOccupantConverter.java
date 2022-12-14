package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.TotalSuccessOfOccupant;
import com.cs491.languageapp.entity.response.TotalSuccessOfOccupantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TotalSuccessOfOccupantConverter {



    public TotalSuccessOfOccupantResponse convert(TotalSuccessOfOccupant successOfOccupant){
        if(successOfOccupant ==null){
            return null;
        }

        return new TotalSuccessOfOccupantResponse
                (
                        successOfOccupant.getId(),
                        successOfOccupant.getA1Level(),
                        successOfOccupant.getA2Level(),
                        successOfOccupant.getB1Level(),
                        successOfOccupant.getB2Level()

                );
    }
}
