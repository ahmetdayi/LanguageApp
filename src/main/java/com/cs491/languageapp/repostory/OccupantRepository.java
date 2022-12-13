package com.cs491.languageapp.repostory;

import com.cs491.languageapp.entity.Occupant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupantRepository extends JpaRepository<Occupant,Integer> {
    Occupant findById(int id);
    Occupant findByEmail(String email);
}
