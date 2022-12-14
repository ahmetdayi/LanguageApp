package com.cs491.languageapp.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cs491.languageapp.entity.TotalSuccessOfOccupant;

public interface TotalSuccessOfOccupantRepository extends JpaRepository<TotalSuccessOfOccupant,Integer> {

    TotalSuccessOfOccupant findByOccupant_Id(int occupantId);

}
