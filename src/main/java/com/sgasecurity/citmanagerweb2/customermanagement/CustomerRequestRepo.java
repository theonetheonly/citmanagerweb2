package com.sgasecurity.citmanagerweb2.customermanagement;

import com.sgasecurity.citmanagerweb2.operations.PlanningTripEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRequestRepo extends JpaRepository<CustomerRequest, Integer> {


    @Query(value = "SELECT * FROM customer_request WHERE id=?1 ORDER BY id ASC ", nativeQuery = true)
//    public CustomerRequest getCustomerDe(String planning_id);
    public  CustomerRequest getSingleCustomerRequestByID(String id);


}
