package com.sgasecurity.citmanagerweb2.customermanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerBranchRepo extends JpaRepository<CustomerBranch, Integer> {

    @Query(value = "SELECT * FROM customer_branch WHERE id=?1 ORDER BY id ASC LIMIT 1 ", nativeQuery = true)
    public  CustomerBranch getSingleCustomerBranch(String id);


}
