package com.cs491.languageapp.entity.Convertor;

import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.response.CreateOccupantResponse;
import com.cs491.languageapp.entity.response.OccupantResponse;
import org.springframework.stereotype.Component;


@Component
public class OccupantConverter {
    public CreateOccupantResponse convert(Occupant occupant){


        return new CreateOccupantResponse(occupant.getId(), occupant.getName(), occupant.getEmail());
    }
    public OccupantResponse convertOccupantResponse(Occupant occupant){
      return new OccupantResponse(occupant.getId(), occupant.getName(), occupant.getEmail());
    }

}
