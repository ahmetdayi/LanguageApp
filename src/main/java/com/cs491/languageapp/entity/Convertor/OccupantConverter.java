package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.response.CreateOccupantResponse;
import com.cs491.languageapp.entity.response.OccupantResponse;
import com.cs491.languageapp.entity.response.UpdateOccupantResponse;
import org.springframework.stereotype.Component;


@Component
public class OccupantConverter {
    public CreateOccupantResponse convert(Occupant occupant){


        return new CreateOccupantResponse(occupant.getId(), occupant.getName(), occupant.getEmail());
    }
    public OccupantResponse convertOccupantResponse(Occupant occupant){
        if(occupant==null){
            return null;
        }
      return new OccupantResponse(occupant.getId(), occupant.getName(), occupant.getEmail());
    }

    public UpdateOccupantResponse convertUpdate(Occupant occupant){

        if (occupant==null){
            return null;
        }
        return new UpdateOccupantResponse
                (
                        occupant.getId(),
                        occupant.getName(),
                        occupant.getEmail(),
                        occupant.getPassword(),
                        occupant.getMatchingPassword()
                );
    }

}
