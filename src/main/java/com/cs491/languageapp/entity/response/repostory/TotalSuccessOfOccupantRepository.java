package com.cs491.languageapp.entity.response.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cs491.languageapp.entity.TotalSuccessOfOccupant;

import java.util.Optional;

public interface TotalSuccessOfOccupantRepository extends JpaRepository<TotalSuccessOfOccupant,Integer> {

    Optional<TotalSuccessOfOccupant> findByOccupant_Id(int occupantId);

}
