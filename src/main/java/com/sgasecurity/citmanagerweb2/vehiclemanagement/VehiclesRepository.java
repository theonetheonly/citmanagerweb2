package com.sgasecurity.citmanagerweb2.vehiclemanagement;

import com.sgasecurity.citmanagerweb2.incidents.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {

    @Query(value = "SELECT * FROM vehicles WHERE id = ?1 ORDER BY id DESC LIMIT 1 ", nativeQuery = true)
    public List<Vehicles> getVehicleById(String vehicle_id);
}