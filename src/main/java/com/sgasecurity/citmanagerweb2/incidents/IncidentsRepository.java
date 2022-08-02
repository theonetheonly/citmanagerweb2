package com.sgasecurity.citmanagerweb2.incidents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidentsRepository extends JpaRepository<Incidents, Integer> {

    @Query(value = "SELECT * FROM incidents WHERE reported_by_id=?1 AND planning_id=?2 ORDER BY id DESC ", nativeQuery = true)
    public List<Incidents> getIncidents(String crew_commander, String plan_id);

}
