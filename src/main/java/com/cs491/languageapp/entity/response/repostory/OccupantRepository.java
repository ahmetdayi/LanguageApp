package com.cs491.languageapp.entity.response.repostory;

import com.cs491.languageapp.entity.Occupant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OccupantRepository extends JpaRepository<Occupant,Integer> {
    Optional<Occupant> findById(int id);
    Optional<Occupant> findByEmail(String email);
}
