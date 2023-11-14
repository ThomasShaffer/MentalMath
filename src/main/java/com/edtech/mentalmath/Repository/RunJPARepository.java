package com.edtech.mentalmath.Repository;

import com.edtech.mentalmath.Entity.dto.UserRunDTO;
import com.edtech.mentalmath.Entity.model.Run;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RunJPARepository extends CrudRepository<Run, Long> {

    @Query(value = "select new com.edtech.mentalmath.Entity.dto.UserRunDTO (u.userName, r.correct, r.category) " +
            "from Run r " +
            "join r.userId u")
    List<com.edtech.mentalmath.Entity.dto.UserRunDTO> getLeaderboardData();

}
