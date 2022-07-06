package com.sgasecurity.citmanagerweb2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanningAndOperationsRepo extends JpaRepository<PlanningAndOperations,Integer> {

//    @Query(value = "SELECT id, timestamp, reference_number, crew_commander_name, crew_commander_id, request_type, planning_operation_status FROM planning_and_operations WHERE crew_commander_id=?1 AND plan_operation_status=?2 ORDER BY id DESC LIMIT 5", nativeQuery = true)
    @Query(value = "SELECT * FROM planning_and_operations WHERE crew_commander_id=?1 AND plan_operation_status=?2 ORDER BY id DESC LIMIT 5", nativeQuery = true)

    public List<PlanningAndOperations> getOperations(int userid, String status);

    @Query(value = "SELECT * FROM planning_and_operations WHERE crew_commander_id=?1 ORDER BY id DESC LIMIT 5", nativeQuery = true)
    public List<PlanningAndOperations> getAllOperationsByCrewCommander(int userid);

}
