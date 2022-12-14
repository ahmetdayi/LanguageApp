package com.cs491.languageapp.entity.response.repostory;

import com.cs491.languageapp.entity.OccupantSuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OccupantSuccessRepository extends JpaRepository<OccupantSuccess,Integer> {
    @Query(value = "SELECT * FROM languagedb.public.occupant_success o WHERE o.occupant_id=?1  and o.is_true=?2",nativeQuery=true)
    List<OccupantSuccess> findByOccupant_IdAndTrueIs(Integer occupantId,boolean isTrue);

    Optional<OccupantSuccess> findTopByOrderByIdAsc();

}
