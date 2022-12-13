package com.cs491.languageapp.service;

import com.cs491.languageapp.entity.Convertor.OccupantConverter;
import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.request.CreateOccupantRequest;
import com.cs491.languageapp.entity.response.CreateOccupantResponse;
import com.cs491.languageapp.entity.response.OccupantResponse;
import com.cs491.languageapp.repostory.OccupantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OccupantService {
    private final OccupantRepository occupantRepository;
    private final OccupantConverter occupantConverter;// Bu tarz classları farklı classlarda calıştırmak istediğimizde dependicy injection kullanıyoruz bu yazdığımız şey de dependicy injection deniyor

    public CreateOccupantResponse create(CreateOccupantRequest request) {

        Occupant occupant = new Occupant(request.getName(), request.getEmail(), request.getPassword());
        CreateOccupantResponse convert = occupantConverter.convert(occupantRepository.save(occupant)); // methodu data base e kaydetmek için yazılır UserREPOSİTORY.SAVE(SAVE)
        return convert;
    }

    public void delete(int id) {
        occupantRepository.deleteById(id);
    }

    public OccupantResponse getById(int id) {
        Occupant occupant = occupantRepository.findById(id);
        OccupantResponse convert = occupantConverter.convertOccupantResponse(occupant);

        return convert;
    }

    protected Occupant findById(int id){
        return occupantRepository.findById(id);
    }

    protected Occupant findByEmail(String email){
        return occupantRepository.findByEmail(email);
    }

    protected void saveTotalSuccess(int occupantId){
        Occupant occupant = findById(occupantId);
        occupant.setTotalSuccess(occupant.getTotalSuccess()+1);
    }




}
