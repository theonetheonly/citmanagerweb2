package com.sgasecurity.citmanagerweb2.operations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanningTropEntriesDocumentsRepo extends JpaRepository<PlanningTripEntriesDocuments, Integer> {

    @Query(value = "SELECT * FROM planning_trip_entries_documents WHERE planning_id=?1  AND customer_request_id=?2 AND planning_trip_entry_id=?3 AND document_name=?4 ORDER BY id ASC ", nativeQuery = true)
    public PlanningTripEntriesDocuments checkIfDocumentExists(String planning_id, String customer_request_id, String planning_trip_entry_id, String document_name);

}
