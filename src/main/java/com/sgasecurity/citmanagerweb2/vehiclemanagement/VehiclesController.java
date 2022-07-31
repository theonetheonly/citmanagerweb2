package com.sgasecurity.citmanagerweb2.vehiclemanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sgasecurity.citmanagerweb2.FileManager;
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
            List<PlanningAndOperations> planVehiclesList = planningAndOperationsRepo.getPlanVehicles(crew_commander_id, "PENDING","STARTED");

            System.out.println("<<<<<<<<<<Plan with ID Found>>>>>>>> " + planVehiclesList.size() + " Entries Found");

            if (planVehiclesList.size() == 1){
                String leadCarID =  planVehiclesList.get(0).getLead_car_id();
                String leadCarRegNo =  planVehiclesList.get(0).getLead_car_regno();
                String chaseCarId =  planVehiclesList.get(0).getChase_car_id();
                String chaseCarRegNo =  planVehiclesList.get(0).getChase_car_regno();

                List<Vehicles> vehiclesList = vehiclesRepository.getVehicleById(leadCarID);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(planVehiclesList);

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at getplanvehicles";
        }
    }
}
