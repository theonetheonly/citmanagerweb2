package com.sgasecurity.citmanagerweb2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SystemOtpRepo extends JpaRepository<SystemOtp,Integer> {
    @Query(value = "SELECT * FROM system_otp WHERE receiver_user_id=?1 ORDER BY id DESC", nativeQuery = true)
    public List<SystemOtp> searchLastOtpByRecieverUserID(String userid);
}

