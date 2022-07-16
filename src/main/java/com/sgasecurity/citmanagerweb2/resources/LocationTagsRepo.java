package com.sgasecurity.citmanagerweb2.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationTagsRepo extends JpaRepository<LocationTags, Integer> {


        @Query(value = "SELECT * FROM location_tag WHERE id=?1 ORDER BY id ASC ", nativeQuery = true)
        public  LocationTags getSingleLocationTagbById(String id);

        @Query(value = "SELECT * FROM location_tags WHERE customer_id=?1 AND customer_branch_id=?2 ORDER BY id ASC LIMIT 1", nativeQuery = true)
        public  LocationTags getSingleLocationTagbByCustomerBranch(String customer_id, String customer_branch_id);

}
