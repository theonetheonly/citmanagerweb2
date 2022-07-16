package com.sgasecurity.citmanagerweb2.customermanagement;

import com.sgasecurity.citmanagerweb2.operations.PlanningTripEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepresentativeRepo extends JpaRepository<CustomerRepresentative, Integer> {

    @Query(value = "SELECT * FROM customer_representative WHERE id=?1 ORDER BY id ASC LIMIT 1 ", nativeQuery = true)
    public  CustomerRepresentative getSingelCustomerRepresentative(String id);
}
