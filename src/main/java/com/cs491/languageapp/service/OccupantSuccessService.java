package com.cs491.languageapp.service;

import com.cs491.languageapp.entity.Convertor.OccupantConverter;
import com.cs491.languageapp.entity.Convertor.OccupantSuccessConverter;
import com.cs491.languageapp.entity.Convertor.WordConverter;
import com.cs491.languageapp.entity.Occupant;
import com.cs491.languageapp.entity.OccupantSuccess;
import com.cs491.languageapp.entity.Word;
import com.cs491.languageapp.entity.request.CreateOccupantSuccessRequest;
import com.cs491.languageapp.entity.response.CreateOccupantSuccessResponse;
import com.cs491.languageapp.repostory.OccupantSuccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OccupantSuccessService {
    private final OccupantSuccessRepository occupantSuccessRepository;
    private final OccupantSuccessConverter occupantSuccessConverter;

    private final WordService wordService;

    private final OccupantService occupantService;


    public List<CreateOccupantSuccessResponse> getAll(){
        return occupantSuccessConverter.convert(occupantSuccessRepository.findAll());
    }
    public CreateOccupantSuccessResponse create(CreateOccupantSuccessRequest request){

        OccupantSuccess occupantSuccess = new OccupantSuccess
                (
                        request.isTrue(),
                        LocalDateTime.now().withNano(0),//bu sekılde kullanımda sımdıkı zamanı getırır with nano dedıgı de zamanı getırırken nano sanıyeyı getırme demek.
                        wordService.getById(request.getWordId()),occupantService.findById(request.getOccupantId())
                );
        OccupantSuccess save = occupantSuccessRepository.save(occupantSuccess);

        if(request.isTrue()){
            occupantService.saveTotalSuccess(request.getOccupantId());
            //TODO bu sekılde yaptıgımızda haftalık tablo sılınıyor ve tum basarılar sayı olarak tutuluyor o yuzden totalsuccess tablosu yapılacak ve userın a1 a2 ... basarıları o tabloda tutulacak

        }

        return occupantSuccessConverter.convert(save);
    }

    public Map<String,Integer> getOccupantSuccessByLevel(int occupantId, String level){

        List<OccupantSuccess> occupantSuccess =
                occupantSuccessRepository.findByOccupant_IdAndTrueIs(occupantId,true);

        List<OccupantSuccess> filtered =
                occupantSuccess.stream().filter
                        (
                                occupantSuccess1 -> occupantSuccess1
                                        .getWord()
                                        .getLevel()
                                        .toString()//TODO a2 levelden hıc yoksa hata verecek dogrulama yap
                                        .equalsIgnoreCase(level)
                        )
                        .toList();
        int allWord = wordService.getByLevel(level).size();
        //noinspection IntegerDivisionInFloatingPointContext
        int size = filtered.size();

        return Map.of("numberOfTrue",size,"allWords",allWord);
    }

    public Integer correctNumberInAWeek(int occupantId){
        List<OccupantSuccess> occupant = occupantSuccessRepository.findByOccupant_IdAndTrueIs(occupantId, true);
        return occupant.size();
    }


    //Bean of StartConfig
    public void deleteAll(){
        if (
                (occupantSuccessRepository.findTopByOrderByIdAsc().getLocalDateTime().getDayOfYear()+7)
                ==LocalDateTime.now().getDayOfYear()
        ){
            occupantSuccessRepository.deleteAll();
        }

    }
}
