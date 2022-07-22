package com.sgasecurity.citmanagerweb2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SystemUsersRepo extends JpaRepository<SystemUsers,Integer> {

    @Query(value = "SELECT * FROM system_users WHERE mobile=?1 AND password=?2 AND status='ENABLED' ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public List<SystemUsers> loginWithPhoneAndPassword(String mobile, String password);

    @Query(value = "SELECT * FROM system_users WHERE rfid_nfc_tag=?1 AND status='ENABLED' ORDER BY id DESC LIMIT 1", nativeQuery = true)
    public List<SystemUsers> loginWithNFCCard(String nfc);

    @Query(value = "SELECT * FROM system_users WHERE id=?1 ", nativeQuery = true)
    public SystemUsers getSingleSystemUser(String id);



}
