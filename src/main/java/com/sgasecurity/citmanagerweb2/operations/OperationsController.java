package com.sgasecurity.citmanagerweb2.operations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sgasecurity.citmanagerweb2.*;
import com.sgasecurity.citmanagerweb2.customermanagement.*;
import com.sgasecurity.citmanagerweb2.resources.LocationTags;
import com.sgasecurity.citmanagerweb2.resources.LocationTagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Controller
public class OperationsController {

    @Autowired
    PlanningAndOperationsRepo planningAndOperationsRepo;

    @Autowired
    PlanningTripEntriesRepo planningTripEntriesRepo;

    @Autowired
    CustomerRepresentativeRepo customerRepresentativeRepo;

    @Autowired
    CustomerRequestRepo customerRequestRepo;

    @Autowired
    LocationTagsRepo locationTagsRepo;

    @Autowired
            SystemOtpRepo systemOtpRepo;
    CommonFunctions commonFunctions =  new CommonFunctions();
    Communication communication = new Communication();


    @ResponseBody
    @RequestMapping("/mobileoperationslist")
    public String loadMobileOperationsList(@RequestParam("user_id") String user_id,
                                           @RequestParam("status_filter") String status_filter,
                                           @RequestParam("num_of_recs") int num_of_recs,
                                           @RequestParam("ordering") String ordering
                            ) {
        try {

            /**  */
            System.out.println("USER ID: "+user_id);
            System.out.println("STATUS: "+status_filter);
            System.out.println("NO OF RECS: "+num_of_recs);
            System.out.println("ORDERING: "+ordering);


            // Default ASC
            List<PlanningAndOperations>  planningList = planningAndOperationsRepo.getOperationsASC(user_id,status_filter,num_of_recs);

            if (ordering.equals("DESC"))
            {
                planningList = planningAndOperationsRepo.getOperationsASC(user_id,status_filter,num_of_recs);
            }

            if (planningList.isEmpty() || planningList == null) {

                return "{\"ERROR\":\"No record found\"}";
            } else {
                List<Object> OpsList = new ArrayList<Object>();
                for (PlanningAndOperations list_entry : planningList) {
                    HashMap<String, String> OpsListEntries = new HashMap<String, String>();
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
        } catch (Exception ex) {
            //      return  "Error:Operations List: "+ex.toString()+"";
            return "{\"error\":\"" + ex.toString() + "\"}";

        }
    }

    @ResponseBody
    @RequestMapping("/getsingleoperation")
    public  String getSingleOperation(@RequestParam("operation_id") String operation_id)
    {
        try {
            List<PlanningAndOperations>  OperationList = planningAndOperationsRepo.getSingleOperationByID(operation_id);

            if (OperationList != null && OperationList.size()==1 )
            {
                PlanningAndOperations SinglePlan = OperationList.get(0);

                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonStr = mapper.writeValueAsString(SinglePlan);
                return jsonStr;
            }
            else{
                return "{\"error\":\"No record found\"}";

            }
        } catch(Exception ex){
            //      return  "Error:Operations List: "+ex.toString()+"";
            return "{\"error\":\"" + ex.toString() + "\"}";

        }
    }

    @ResponseBody
    @RequestMapping("/confirmresources")
    public String confirmJourneyResources(@RequestParam("id") String id,
                                          @RequestParam("lead_car_confirmation") String lead_car_confirmation,
                                          @RequestParam("chase_car_confirmation") String chase_car_confirmation,
                                          @RequestParam("lead_driver_confirmation") String lead_driver_confirmation,
                                          @RequestParam("chase_driver_confirmation") String chase_driver_confirmation,
                                          @RequestParam("support_staff_confirmation") String support_staff_confirmation,
                                          @RequestParam("police_officers_confirmation") String police_officers_confirmation,
                                          @RequestParam("seals_confirmation") String seals_confirmaton,
                                          @RequestParam("boxbags_confirmation") String boxes_confirmation
                                          )
    {





        try{

            System.out.println("Confirm resourses test::\n OK");
            List<PlanningAndOperations> PlanningAndOperationsList = planningAndOperationsRepo.getSingleOperationByID(id);
            PlanningAndOperations PO = PlanningAndOperationsList.get(0);

            PO.setLead_car_confirmation(lead_car_confirmation);
            PO.setChase_car_confirmation(chase_car_confirmation);
            PO.setLead_driver_confirmation(lead_driver_confirmation);
            PO.setChase_driver_confirmation(chase_driver_confirmation);
            PO.setSupport_staff_confirmation(support_staff_confirmation);
            PO.setPolice_officers_confirmation(police_officers_confirmation);
            PO.setSeals_confirmation(seals_confirmaton);
            PO.setBoxbag_confirmation(boxes_confirmation);
            planningAndOperationsRepo.save(PO);

            int non_confirm = 0;
            String non_confirm_message ="";
            if (lead_car_confirmation.contains("NO"))
            {
                non_confirm ++;
                non_confirm_message = "Lead car was not confirmed\\n";
            }
            if (chase_car_confirmation.contains("NO"))
            {
                non_confirm ++;
                non_confirm_message = non_confirm_message + "Chase car was not confirmed\\n";
            }
            if (lead_driver_confirmation.contains("NO"))
            {
                non_confirm ++;
                non_confirm_message = non_confirm_message + "Lead driver was not confirmed\\n";

            }
            if(chase_driver_confirmation.contains("NO"))
            {
                non_confirm++;
                non_confirm_message = non_confirm_message+ "Chase driver was not confirmed\\n";

            }

            if(support_staff_confirmation.contains("NO"))
            {
                non_confirm++;
                non_confirm_message = non_confirm_message+ "Support staff were not confirmed\\n";

            }

            if (seals_confirmaton.contains("NO"))
            {
                non_confirm++;
                non_confirm_message = non_confirm_message+ "Seals were not confirmed\\n";
            }

            if (boxes_confirmation.contains("NO"))
            {
                non_confirm++;
                non_confirm_message = non_confirm_message+ "Boxes were not confirmed\\n";
            }

            String response_message ="";


            if (non_confirm >0)
            {
                response_message  ="Some resources were not confirmed\\n";
                response_message = response_message+non_confirm_message;
                return "{\"error\":\" Operation Ref No: " + PO.getReference_number() + " - " + response_message +"\"}";
            }
            else{
                response_message ="All required resources successfully confirmed";
                return "{\"success\":\" Operation Ref No: " + PO.getReference_number() + " - " +response_message+"\"}";
            }


            // return "{\"success\":\"Test response\"}";
        }
        catch (Exception ex)
        {
            System.out.println("Error:\n" +ex.toString() );

            return "{\"error\":\"" + ex.toString() + " at confirmJourneyResources\"}";
        }

    }


    @ResponseBody
    @RequestMapping("/startjourney")
    public  String startJourney(@RequestParam("id") String id)
    {
        /* Start journey */
        try{
            System.out.println("START JOURNEY ID: "+ id);
            System.out.println("Confirm resourses test::\n OK");
            List<PlanningAndOperations> PlanningAndOperationsList = planningAndOperationsRepo.getSingleOperationByID(id);
            System.out.println(PlanningAndOperationsList.size() + " Operations found");
            PlanningAndOperations PO = PlanningAndOperationsList.get(0);

            PO.setPlan_operation_stage("OPERATIONS");
            PO.setPlan_operation_status("STARTED");

            planningAndOperationsRepo.save(PO);

            String ref_no = PO.getReference_number();

            return "{\"success\":\"Journey Ref No: "+ref_no+ " Started\"}";
        }
        catch (Exception ex)
        {
            System.out.println("Error\n"+ex.toString());
            return "{\"error\":\"" + ex.toString() + " at startJourney\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/gettripentries")
    public  String getTripEntries(@RequestParam("id") String id)
    {
        /* Start journey */
        try{
            System.out.println("PLAN/OPERATION ID: "+ id);

            List<PlanningTripEntries> planningTripEntriesList = planningTripEntriesRepo.getPlanningTripByEntrriesByPlanningIDASC(id);
            System.out.println("<<<<<<<<<<Entries Found>>>>>>>> "+ planningTripEntriesList.size() + " Trip Entries Found");

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonStr = mapper.writeValueAsString(planningTripEntriesList);
            return jsonStr;
            /*          List<PlanningAndOperations> PlanningAndOperationsList = planningAndOperationsRepo.getSingleOperationByID(id);
            System.out.println(PlanningAndOperationsList.size() + " Operations found");
            PlanningAndOperations PO = PlanningAndOperationsList.get(0);
            PO.setPlan_operation_stage("OPERATIONS");
            PO.setPlan_operation_status("STARTED");
            planningAndOperationsRepo.save(PO);
            String ref_no = PO.getReference_number();
            */
        }
        catch (Exception ex)
        {
            System.out.println("Error\n"+ex.toString());
            return "{\"error\":\"" + ex.toString() + " at gettripentries";
        }
    }

    @ResponseBody
    @RequestMapping("/sendprearrivalnotification")
    public  String sendPrearrivalNotification(@RequestParam("customer_representative_id") String customer_rep_id,
        @RequestParam("reference_number") String reference_number)
    {
        /* Send prearrival notification */
        try {

            System.out.println(">>>>>Customer Rep ID: "+customer_rep_id);
            System.out.println(">>>>>OP ref no:: "+reference_number);

            CustomerRepresentative CR = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_rep_id);

            String mobile_phone  = CR.getMobileNumber();
            String customer_repnames = CR.getCustomerRepresentativeName();

            String message = "Attention "+customer_repnames+", This is a pre-arrival notification for operation ref. "+reference_number+" from the SGA CIT team. Please be aware we may arrive at your premises within the next 20 minutes";
            communication.sendSMS(mobile_phone,message);

            System.out.println(">>>>>Mobile Phone: "+mobile_phone);
            System.out.println(">>>>>Message: "+message);

            String mobile_phone_1  = mobile_phone.substring(0,4);
            String mobile_phone_2  = mobile_phone.substring(mobile_phone.length() -3,10);
            String final_mobile_phone = mobile_phone_1 + "***" + mobile_phone_2;


            return "{\"success\":\"Pre-arrival message has been sent to "+customer_repnames +" via "+final_mobile_phone + "\"}";

        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @ResponseBody
    @RequestMapping("/sendarrivalnotification")
    public  String sendArrivalNotification(@RequestParam("customer_representative_id") String customer_rep_id,
                                              @RequestParam("reference_number") String reference_number)
    {
        /* Send prearrival notification */
        try {

            System.out.println(">>>>>Customer Rep ID: "+customer_rep_id);
            System.out.println(">>>>>OP ref no:: "+reference_number);

            CustomerRepresentative CR = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_rep_id);

            String mobile_phone  = CR.getMobileNumber();
            String customer_repnames = CR.getCustomerRepresentativeName();

            String message = "Attention "+customer_repnames+", This is an arrival notification for operation ref. "+reference_number+" from the SGA CIT team. We are now at your premises";
            communication.sendSMS(mobile_phone,message);

            System.out.println(">>>>>Mobile Phone: "+mobile_phone);
            System.out.println(">>>>>Message: "+message);

            String mobile_phone_1  = mobile_phone.substring(0,4);
            String mobile_phone_2  = mobile_phone.substring(mobile_phone.length() -3,10);
            String final_mobile_phone = mobile_phone_1 + "***" + mobile_phone_2;


            return "{\"success\":\"Arrival message has been sent to "+customer_repnames +" via "+final_mobile_phone + "\"}";

        } catch (Exception ex) {
            return ex.toString();
        }
    }


    @ResponseBody
    @RequestMapping("/scanlocationtag")
    public  String sendArrivalNotification(@RequestParam("plan_id") String plan_id,
                                           @RequestParam("customer_request_id") String customer_request_id,
                                           @RequestParam("user_id") String user_id,
                                           @RequestParam("location_tag") String location_tag,
                                           @RequestParam("action") String action
                                           )
    {
        /* Send prearrival notification */
        try {
  //         System.out.println(">>>>>Customer Rep ID: "+customer_rep_id);
    //        System.out.println(">>>>>OP ref no:: "+reference_number);

                if (location_tag.equals(this.getLocationTagFromCustomerRequest(customer_request_id, action, location_tag)))
                {
                    return "{\"success\":\"Location tag confirmed successfully\"}";
                }
                else
                {
                    return "{\"error\":\"Location tag does not match expected location\"}";
                }

        } catch (Exception ex) {
            return ex.toString();
        }
    }


    private String getLocationTagFromCustomerRequest(String customer_request_id, String action, String sent_location_tag)
    {
        try{
            System.out.println("Customer request id>>>>>>>>>>>>"+customer_request_id);

            CustomerRequest CRQ = customerRequestRepo.getSingleCustomerRequestByID(customer_request_id);
//            String location_tag ="";
            String required_cust_id ="";
            String required_cust_branch_id ="";
            switch (action)
            {
                case "PICK":
                    System.out.println(">>>> ACTION>>> PICK");
                    required_cust_id = CRQ.getSourceClientId();
                    required_cust_branch_id = CRQ.getSourceClientBranchId();
                    break;
                case "DR0P":
                    System.out.println(">>>> ACTION>>> DROP");
                    required_cust_id = CRQ.getDestinationClientId();
                    required_cust_branch_id = CRQ.getDestinationClientBranchId();

                    break;
                default:
                    System.out.println(">>>> ACTION>>> PICK");
                    required_cust_id = CRQ.getSourceClientId();
                    required_cust_branch_id = CRQ.getSourceClientBranchId();

                    break;
            }

            System.out.println("=========== Required Customer ID ========= "+ required_cust_id);
            System.out.println("=========== Required Branch ID ========= "+ required_cust_branch_id);


            LocationTags LCT = locationTagsRepo.getSingleLocationTagbByCustomerBranch(required_cust_id, required_cust_branch_id);
            String TAG_location = LCT.getCode(); //.toString();

            System.out.println("APP Location Tag>>>>>>>>>>: "+ sent_location_tag+ "\n");
            System.out.println("DB Location Tag>>>>>>>>>>: "+ TAG_location+ "\n");

            return LCT.getCode();
        }
        catch (Exception ex)
        {
            System.out.println("Error\n"+ex.toString());
            return "{\"error\":\"" + ex.toString() + " at getLocationTagFromCustomeRequest \"}";

        }
    }


    @ResponseBody
    @RequestMapping("/sendcustomerlocationotp")
    public  String sendCustomerLocationOTP(@RequestParam("plan_id") String id,
                                           @RequestParam("customer_request_id") String customer_request_id,
                                           @RequestParam("customer_representative_id") String customer_representative_id,
                                           @RequestParam("customer_representative_name") String customer_representative_name,
                                           @RequestParam("user_id") String user_id
    )
    {
        System.out.println("Customer Rep ID: "+ customer_representative_id+"\n");
            /* Send CustomerOTP */

            String mobile ="";
            String otp_response ="";
            try {
//                CustomerManagement customerManagement = new CustomerManagement();
                CustomerRepresentative CREP = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_representative_id);
                System.out.println("Customer Representative Name: >> " + CREP.getCustomerRepresentativeName());
                mobile = CREP.getMobileNumber();
                // mobile = customerManagement.getCustomerRepMobile(customer_representative_id);
                System.out.println("mobile: " + mobile + "\n");

                otp_response = this.generateOTP(mobile, "", user_id, "CIT CREW ARRIVAL CONFIRMATION", "2");

                return otp_response;
            }
            catch (Exception ex)
            {
                System.out.println("Error\n"+ex.toString());
                return "{\"error\":\"" + ex.toString() + " at sendCustomerLocationOTP \"}";

            }
        }


    @ResponseBody
    @RequestMapping("/confirmcustomerlocationotp")
    public  String confirmCustomerLocationOTP(@RequestParam("plan_id") String id,
                                           @RequestParam("customer_request_id") String customer_request_id,
                                           @RequestParam("customer_representative_id") String customer_representative_id,
                                           @RequestParam("customer_representative_name") String customer_representative_name,
                                           @RequestParam("user_id") String user_id,
                                           @RequestParam("otp_reply") String otp_reply
    )
    {
        try {

            System.out.println("Confirming OTP\n");
            List<SystemOtp> systemOtpList = systemOtpRepo.searchLastOtpByRecieverUserID(user_id);
            SystemOtp systemotp_single  = systemOtpList.get(0); //.getOtpCode().toString();

            if (systemotp_single.getOtpCode().equals(otp_reply) && systemotp_single.getStatus().equals("PENDING")) {
                systemotp_single.setOtpCodeReply(otp_reply);
                systemotp_single.setStatus("SUCCESS");
                systemOtpRepo.save(systemotp_single);

            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            HashMap<String, String > myresponse = new HashMap<>();
            myresponse.put("OTP_CONFIRM_STATUS","SUCCESS");
            String jsonStr = mapper.writeValueAsString(myresponse);
            System.out.println("REPLY: "+ jsonStr);

            return jsonStr;  // jsonStr;

        } catch (Exception ex) {
            return "{\"error\":\"" + ex.toString() + " at ConfirmCustomerLocationOTP\"}";
        }
    }

    public String generateOTP(String mobile,String email,String user_id, String context, String expire_minutes)
    {
        try{

            Random rnd = new Random();
            int otp_code = 10000+rnd.nextInt(90000);
            System.out.println("Random no generated: "+otp_code);

            SystemOtp systemOtp= new SystemOtp(Integer.toString(otp_code), "00000","SMS",mobile,email,context,"pending",Integer.parseInt(user_id));
/*            systemOtp.setOtpCode(Integer.toString(otp_code));
            systemOtp.setOtpCodeReply("00000");
            systemOtp.setContext("FIELD_USER_LOGIN");
            systemOtp.setReceiverUserId(Integer.parseInt(user_id));
            systemOtp.setSendMode("MOBILE");
            systemOtp.setSendToEmail(email);
            systemOtp.setSendToMobile(mobile);
            systemOtp.setStatus("PENDING");*/
            systemOtpRepo.save(systemOtp);


            String message ="<#> Your CIT OTP Code for "+context+" is "+Integer.toString(otp_code);
            message = message + ". It will expire in "+expire_minutes+" minute(s)";

            Communication communication = new Communication();
            communication.sendSMS(mobile,message);
            HashMap<String, String> myresponse= new HashMap<>();

            myresponse.put("OTP_STATUS","SUCCESS");
            myresponse.put("OTP_GENERATED",Integer.toString(otp_code));

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonStr = mapper.writeValueAsString(myresponse);
            return jsonStr;

        } catch (Exception ex) {
            return "{\"error\":\"" + ex.toString() + "  at generateOTP \"}";
        }
    }

}
