package com.sgasecurity.citmanagerweb2.planningtripentriesevents;

import com.sgasecurity.citmanagerweb2.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlanningTripEntryEventsController {

    @Autowired
    PlanningTripEntriesEventsRepository planningTripEntriesEventsRepository;

    FileManager fileManager = new FileManager();

    @ResponseBody
    @RequestMapping("/inserttripevent")
    public String insertTripEvent(
            @RequestParam("planning_id") String planning_id,
            @RequestParam("planning_trip_entry_id") String planning_trip_entry_id,
            @RequestParam("event_name") String event_name,
            @RequestParam("event_value") String event_value,
            @RequestParam("event_owner_id") String event_owner_id,
            @RequestParam("event_owner_name") String event_owner_name,
            @RequestParam("event_owner_type") String event_owner_type,
            @RequestParam("event_status") String event_status,
            @RequestParam("event_comments") String event_comments,
            @RequestParam("audit_trail_user_id") String audit_trail_user_id
    ) {
        try {

            PlanningTripEntriesEvents planningTripEntriesEvents = new PlanningTripEntriesEvents();
            planningTripEntriesEvents.setPlanning_id(planning_id);
            planningTripEntriesEvents.setPlanning_trip_entry_id(planning_trip_entry_id);
            planningTripEntriesEvents.setEvent_name(event_name);
            planningTripEntriesEvents.setEvent_value(event_value);
            planningTripEntriesEvents.setEvent_owner_id(event_owner_id);
            planningTripEntriesEvents.setEvent_owner_name(event_owner_name);
            planningTripEntriesEvents.setEvent_owner_type(event_owner_type);
            planningTripEntriesEvents.setEvent_status(event_status);
            planningTripEntriesEvents.setEvent_comments(event_comments);
            planningTripEntriesEvents.setAudit_trail_user_id(audit_trail_user_id);

            planningTripEntriesEventsRepository.save(planningTripEntriesEvents);

            String output = "The Event has been successfully recorded";

            return "{\"success\":\"" + output + "\"}";

        } catch (Exception ex) {
            fileManager.writeToFile("operations_errors.txt", true, ex.toString() + " at insertTripEvent");
            return "{\"error\":\"" + ex.toString() + "  at insertTripEvent \"}";
        }

    }
}
