package com.sgasecurity.citmanagerweb2.incidents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sgasecurity.citmanagerweb2.FileManager;
import com.sgasecurity.citmanagerweb2.operations.PlanningTripEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IncidentsController {

    FileManager fileManager = new FileManager();

    @Autowired
    IncidentsRepository incidentsRepository;

    @ResponseBody
    @RequestMapping("/getincidents")
    public String getIncidents(@RequestParam("crew_commander_id") String crew_commander_id,
                               @RequestParam("plan_id") String plan_id) {

        try {
            List<Incidents> incidentsList = incidentsRepository.getIncidents(crew_commander_id, plan_id);

            System.out.println("<<<<<<<<<<Incidents Found>>>>>>>> " + incidentsList.size() + " Incidents Entries Found");

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(incidentsList);

        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at gettripentries";
        }
    }

    @ResponseBody
    @RequestMapping("/insertincident")
    public String insertIncident(@RequestParam("plan_id") String plan_id,
                                 @RequestParam("reported_by_id") String reported_by_id,
                                 @RequestParam("incident_time") String incident_time,
                                 @RequestParam("reported_by_name") String reported_by_name,
                                 @RequestParam("incident_type") String incident_type,
                                 @RequestParam("incident_description") String incident_description
    ) {

        try {

            Incidents incident = new Incidents();
            incident.setPlanning_id(plan_id);
            incident.setReported_by_id(reported_by_id);
            incident.setIncident_time(incident_time);
            incident.setCrew_commander_name(reported_by_name);
            incident.setType(incident_type);
            incident.setDescription(incident_description);
            incident.setAudit_trail_user_id(reported_by_id);

            incidentsRepository.save(incident);

            String output = "The incident has been successfully recorded";

            return "{\"success\":\"" + output + "\"}";


        } catch (Exception ex) {
            fileManager.writeToFile("operations_errors.txt", true, ex.toString() + " at insertIncident");
            return "{\"error\":\"" + ex.toString() + "  at insertIncident \"}";
        }
    }

    @ResponseBody
    @RequestMapping("/updateincident")
    public String updateIncident(@RequestParam("incident_id") int incident_id,
                                 @RequestParam("reported_by_id") String reported_by_id,
                                 @RequestParam("incident_time") String incident_time,
                                 @RequestParam("incident_type") String incident_type,
                                 @RequestParam("incident_description") String incident_description
    ) {

        try {

            Incidents incident = incidentsRepository.findById(incident_id).orElse(null);

            if (incident != null) {
                incident.setIncident_time(incident_time);
                incident.setType(incident_type);
                incident.setDescription(incident_description);
                incident.setAudit_trail_user_id(reported_by_id);

                incidentsRepository.save(incident);

                String output = "Incident updated successfully.";

                return "{\"success\":\"" + output + "\"}";

            } else {

                return "{\"error\":\"Incident not found\"}";
            }


        } catch (Exception ex) {
            fileManager.writeToFile("operations_errors.txt", true, ex.toString() + " at updateIncident");
            return "{\"error\":\"" + ex.toString() + "  at updateIncident \"}";
        }
    }
}
