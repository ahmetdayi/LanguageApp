package com.cs491.languageapp.service;

import com.cs491.languageapp.core.exception.OccupantDoesntExistException;
import com.cs491.languageapp.core.exception.constant.Constant;
import com.cs491.languageapp.entity.Convertor.OccupantConverter;
import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.TotalSuccessOfOccupant;
import com.cs491.languageapp.entity.request.CreateOccupantRequest;
import com.cs491.languageapp.entity.request.UpdateOccupantRequest;
import com.cs491.languageapp.entity.response.CreateOccupantResponse;
import com.cs491.languageapp.entity.response.OccupantResponse;
import com.cs491.languageapp.entity.response.UpdateOccupantResponse;
import com.cs491.languageapp.repostory.OccupantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OccupantService {
    private final OccupantRepository occupantRepository;
    private final OccupantConverter occupantConverter;// Bu tarz classları farklı classlarda calıştırmak istediğimizde dependicy injection kullanıyoruz bu yazdığımız şey de dependicy injection deniyor

    private final TotalSuccessOfOccupantService successOfOccupantService;
    public CreateOccupantResponse create(CreateOccupantRequest request) {

        Occupant occupant = new Occupant(request.getName(), request.getEmail(), request.getPassword(), request.getMatchingPassword());
        CreateOccupantResponse convert = occupantConverter.convert(occupantRepository.save(occupant)); // methodu data base e kaydetmek için yazılır UserREPOSİTORY.SAVE(SAVE)

      //total success create
        TotalSuccessOfOccupant
                successOfOccupant =
                new TotalSuccessOfOccupant(0,0,0,0,findById(convert.getId()));

        successOfOccupantService.create(successOfOccupant);
        return convert;
    }

    public UpdateOccupantResponse update(UpdateOccupantRequest request){
        Occupant occ = findById(request.getId());
        occ.setName(request.getName());
        occ.setPassword(request.getPassword());
        occ.setMatchingPassword(request.getMatchingPassword());
        return occupantConverter.convertUpdate(occ);



    }

    public void delete(int id) {
        occupantRepository.deleteById(id);
    }

    public OccupantResponse getById(int id) {
        Occupant occupant = findById(id);
        return occupantConverter.convertOccupantResponse(occupant);
    }

    protected Occupant findById(int id){
        return occupantRepository.
                findById(id).
                orElseThrow(()->new OccupantDoesntExistException(Constant.OCCUPANT_DOESNT_EXIST));
    }

    protected Occupant findByEmail(String email){
        return occupantRepository.
                findByEmail(email).
                orElseThrow(()->new OccupantDoesntExistException(Constant.OCCUPANT_DOESNT_EXIST));
    }





}
