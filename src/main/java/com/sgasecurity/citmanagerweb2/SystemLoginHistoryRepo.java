package com.sgasecurity.citmanagerweb2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SystemLoginHistoryRepo  extends JpaRepository<SystemLoginHistory,Integer> {

    @Query(value = "SELECT * FROM system_login_history WHERE user_id=?1 ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public List<SystemUsers> getLastLogin(String system_user_id);
}
