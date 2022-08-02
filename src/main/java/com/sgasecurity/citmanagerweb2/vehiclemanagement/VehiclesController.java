package com.sgasecurity.citmanagerweb2.vehiclemanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sgasecurity.citmanagerweb2.FileManager;
import com.sgasecurity.citmanagerweb2.incidents.Incidents;
import com.sgasecurity.citmanagerweb2.operations.PlanningAndOperations;
import com.sgasecurity.citmanagerweb2.operations.PlanningAndOperationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VehiclesController {


    FileManager fileManager = new FileManager();

    @Autowired
    PlanningAndOperationsRepo planningAndOperationsRepo;

    @Autowired
    VehiclesRepository vehiclesRepository;

    @ResponseBody
    @RequestMapping("/getplanvehicles")
    public String getPlanVehicles(@RequestParam("crew_commander_id") String crew_commander_id) {

        try {
            List<PlanningAndOperations> planVehiclesList = planningAndOperationsRepo.getPlanVehicles(crew_commander_id, "PENDING", "STARTED");

            if (planVehiclesList.size() > 0) {


                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                return mapper.writeValueAsString(planVehiclesList);
            } else {
                return "[{\"error\":\"No vehicles found matching your request\"}]";

            }

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "[{\"error\":\"" + ex.toString() + "\"}]";
        }
    }

    @ResponseBody
    @RequestMapping("/getvehicledetails")
    public String getVehicleDetails(@RequestParam("vehicle_id") String vehicle_id) {

        try {
            List<Vehicles> vehicle = vehiclesRepository.getVehicleById(vehicle_id);


            if (vehicle.size() == 1) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                return mapper.writeValueAsString(vehicle);
            } else {
                String output = String.format("Vehicle with ID %s not found.", vehicle_id);

                return "{\"error\":\"" + output + "\"}";
            }

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + "\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/updatevehiclecondition")
    public String updateVehicleCondition(@RequestParam("vehicle_id") int vehicle_id,
                                         @RequestParam("vehicle_condition") String vehicle_condition,
                                         @RequestParam("vehicle_condition_comments") String vehicle_condition_comments
    ) {

        try {
            Vehicles vehicle = vehiclesRepository.findById(vehicle_id).orElse(null);

            if (vehicle != null) {

                vehicle.setGeneral_condition(vehicle_condition);
                vehicle.setGeneral_condition_comments(vehicle_condition_comments);


                vehiclesRepository.save(vehicle);

                String output = "Vehicle condition updated successfully.";

                return "{\"success\":\"" + output + "\"}";

            } else {

                return "{\"error\":\"Vehicle not found\"}";
            }

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + "\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/updatevehiclemeasurements")
    public String updateVehicleMeasurements(@RequestParam("vehicle_id") int vehicle_id,
                                            @RequestParam("fuel_level") String fuel_level,
                                            @RequestParam("odometer_reading") String odometer_reading
    ) {

        try {
            Vehicles vehicle = vehiclesRepository.findById(vehicle_id).orElse(null);

            if (vehicle != null) {

                vehicle.setCurrent_fuel_level(fuel_level);
                vehicle.setOdometer_reading(odometer_reading);


                vehiclesRepository.save(vehicle);

                String output = "Vehicle measurements updated successfully.";

                return "{\"success\":\"" + output + "\"}";

            } else {

                return "{\"error\":\"Vehicle not found\"}";
            }

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + "\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/updatelockstatus")
    public String updateLockStatus(@RequestParam("vehicle_id") int vehicle_id,
                                   @RequestParam("lock_status") String lock_status
    ) {

        try {
            Vehicles vehicle = vehiclesRepository.findById(vehicle_id).orElse(null);

            if (vehicle != null) {

                vehicle.setLock_status(lock_status);


                vehiclesRepository.save(vehicle);

                String output = "Vehicle lock status updated successfully.";

                return "{\"success\":\"" + output + "\"}";

            } else {

                return "{\"error\":\"Vehicle not found\"}";
            }

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + "\"}";
        }
    }
}
