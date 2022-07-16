package com.sgasecurity.citmanagerweb2.operations;

import com.sgasecurity.citmanagerweb2.PlanningAndOperations;
import com.sgasecurity.citmanagerweb2.SystemOtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanningTripEntriesRepo extends JpaRepository<PlanningTripEntries,Integer> {

    @Query(value = "SELECT * FROM planning_trip_entries WHERE planning_id=?1 ORDER BY id ASC ", nativeQuery = true)
    public List<PlanningTripEntries> getPlanningTripByEntrriesByPlanningIDASC(String planning_id);

}
