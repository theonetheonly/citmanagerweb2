package com.sgasecurity.citmanagerweb2.customermanagement;

import com.sgasecurity.citmanagerweb2.operations.PlanningTripEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{



}
