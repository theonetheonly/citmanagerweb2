package com.sgasecurity.citmanagerweb2.operations;

import com.sgasecurity.citmanagerweb2.operations.PlanningAndOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanningAndOperationsRepo extends JpaRepository<PlanningAndOperations,Integer> {

//    ORDER BY ?3 DESC LIMIT ?4
//    @Query(value = "SELECT id, timestamp, reference_number, crew_commander_name, crew_commander_id, request_type, planning_operation_status FROM planning_and_operations WHERE crew_commander_id=?1 AND plan_operation_status=?2 ORDER BY id DESC LIMIT 5", nativeQuery = true)
    @Query(value = "SELECT * FROM planning_and_operations WHERE crew_commander_id=?1 AND plan_operation_status=?2 ORDER BY id DESC LIMIT ?3 ", nativeQuery = true)
    public List<PlanningAndOperations> getOperationsDSC(String userid, String status, int numrecs);

    @Query(value = "SELECT * FROM planning_and_operations WHERE crew_commander_id=?1 AND plan_operation_status=?2 ORDER BY id ASC LIMIT ?3 ", nativeQuery = true)
    public List<PlanningAndOperations> getOperationsASC(String userid, String status, int numrecs);

    @Query(value = "SELECT * FROM planning_and_operations WHERE crew_commander_id=?1 ORDER BY id DESC LIMIT 5", nativeQuery = true)
    public List<PlanningAndOperations> getAllOperationsByCrewCommander(String userid);


    @Query(value = "SELECT * FROM planning_and_operations WHERE id=?1 ", nativeQuery = true)
    public List<PlanningAndOperations> getSingleOperationByID(String operation_id);

    @Query(value = "SELECT * FROM planning_and_operations WHERE id=?1 ", nativeQuery = true)
    public PlanningAndOperations getSingleOperationByIDObj(String operation_id);


    @Query(value = "SELECT * FROM planning_and_operations WHERE id=?1 ", nativeQuery = true)
    public PlanningAndOperations getSingleOperationByIDSingleObject(String operation_id);



    @Query(value = "SELECT * FROM planning_and_operations WHERE id=?1 AND seals_serials IN(?2) ", nativeQuery = true)
    public List<PlanningAndOperations> checkPlanScannedSeals(String operation_id, String seals);


    @Query(value = "SELECT * FROM planning_and_operations WHERE id=?1 AND seals_serials LIKE ?2 ", nativeQuery = true)
    public List<PlanningAndOperations> checkPlanScannedSealsEach(String operation_id, String seals);


    @Query(value = "SELECT * FROM planning_and_operations WHERE crew_commander_id = ?1 AND (plan_operation_status = ?2 OR plan_operation_status = ?3) LIMIT 1", nativeQuery = true)
    public List<PlanningAndOperations> getPlanVehicles(String crew_commander_id, String plan_operation_status, String plan_operation_status_2);
}
