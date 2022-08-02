package com.sgasecurity.citmanagerweb2.planningtripentriesevents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanningTripEntriesEventsRepository extends JpaRepository<PlanningTripEntriesEvents, Integer> {

    @Query(value = "SELECT * FROM planning_trip_entries_events WHERE planning_id=?1 ORDER BY id DESC ", nativeQuery = true)
    public List<PlanningTripEntriesEvents> getByPlanning_id(String plan_id);
}