package com.sgasecurity.citmanagerweb2;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class EntryPoint {

    @Autowired
    PlanningAndOperationsRepo planningAndOperationsRepo;

    @ResponseBody
    @RequestMapping("/")
    public String Home() {
        return "it works";
    }

        @ResponseBody
    @RequestMapping("/mobileoperationslist")
    public String loadMobileOperationsList()
    {
        try {
            int userid = 9;
            String planning_operation_status = "PENDING";
            List<PlanningAndOperations> planningList = planningAndOperationsRepo.getOperations(userid, planning_operation_status);
            if (planningList.isEmpty() || planningList ==null) {

                return "{\"error\":\"No record found\"}";
            } else {
                
                
                List<Object> OpsList  = new ArrayList<Object>();
                

                for (PlanningAndOperations list_entry: planningList) {
                    HashMap<String,String> OpsListEntries = new HashMap<String,String>();

                    OpsListEntries.put("id", list_entry.getId().toString());
                    OpsListEntries.put("timestamp", list_entry.getTimestamp().toString());
                    OpsListEntries.put("reference_number", list_entry.getReference_number().toString());
                    OpsListEntries.put("request_type", list_entry.getRequest_type().toString());
                    OpsListEntries.put("crew_commander_name", list_entry.getCrew_commander_name().toString());
                    OpsListEntries.put("plan_operation_status", list_entry.getPlan_operation_status().toString());

                                System.out.println(list_entry.getId());
                                System.out.println(list_entry.getCrew_commander_name());

                                OpsList.add(OpsListEntries);

                }
                
                        
                        
                
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonStr = mapper.writeValueAsString(OpsList);
                return jsonStr;
            }
        }
        catch (Exception ex)
        {
      //      return  "Error:Operations List: "+ex.toString()+"";
            return "{\"error\":\""+ex.toString()+ "\"}";

        }
    }



}
