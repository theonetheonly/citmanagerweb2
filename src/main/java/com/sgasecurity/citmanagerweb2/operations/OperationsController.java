package com.sgasecurity.citmanagerweb2.operations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sgasecurity.citmanagerweb2.*;
import com.sgasecurity.citmanagerweb2.customermanagement.*;
import com.sgasecurity.citmanagerweb2.resources.LocationTags;
import com.sgasecurity.citmanagerweb2.resources.LocationTagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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


    @Autowired
    PlanningTropEntriesDocumentsRepo planningTropEntriesDocumentsRepo;


    @Autowired
    CustomerBranchRepo customerBranchRepo;


    @Autowired
    SystemUsersRepo systemUsersRepo;
    CommonFunctions commonFunctions = new CommonFunctions();
    Communication communication = new Communication();

    FileManager fileManager = new FileManager();


    @ResponseBody
    @RequestMapping("/mobileoperationslist")
    public String loadMobileOperationsList(@RequestParam("user_id") String user_id,
                                           @RequestParam("status_filter") String status_filter,
                                           @RequestParam("num_of_recs") int num_of_recs,
                                           @RequestParam("ordering") String ordering
    ) {
        try {

            /**  */
            System.out.println("USER ID: " + user_id);
            System.out.println("STATUS: " + status_filter);
            System.out.println("NO OF RECS: " + num_of_recs);
            System.out.println("ORDERING: " + ordering);


            // Default ASC
            List<PlanningAndOperations> planningList = planningAndOperationsRepo.getOperationsASC(user_id, status_filter, num_of_recs);

            if (ordering.equals("DESC")) {
                planningList = planningAndOperationsRepo.getOperationsASC(user_id, status_filter, num_of_recs);
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
    public String getSingleOperation(@RequestParam("operation_id") String operation_id) {
        try {
            List<PlanningAndOperations> OperationList = planningAndOperationsRepo.getSingleOperationByID(operation_id);

            if (OperationList != null && OperationList.size() == 1) {
                PlanningAndOperations SinglePlan = OperationList.get(0);
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                String jsonStr = mapper.writeValueAsString(SinglePlan);
                return jsonStr;
            } else {
                return "{\"error\":\"No record found\"}";

            }
        } catch (Exception ex) {
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
    ) {


        try {

            System.out.println("Confirm resources test::\n OK");

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
            String non_confirm_message = "";
            if (lead_car_confirmation.contains("NO")) {
                non_confirm++;
                non_confirm_message = "Lead car was not confirmed\\n";
            }
            if (chase_car_confirmation.contains("NO")) {
                non_confirm++;
                non_confirm_message = non_confirm_message + "Chase car was not confirmed\\n";
            }
            if (lead_driver_confirmation.contains("NO")) {
                non_confirm++;
                non_confirm_message = non_confirm_message + "Lead driver was not confirmed\\n";

            }
            if (chase_driver_confirmation.contains("NO")) {
                non_confirm++;
                non_confirm_message = non_confirm_message + "Chase driver was not confirmed\\n";

            }

            if (support_staff_confirmation.contains("NO")) {
                non_confirm++;
                non_confirm_message = non_confirm_message + "Support staff were not confirmed\\n";

            }

            if (seals_confirmaton.contains("NO")) {
                non_confirm++;
                non_confirm_message = non_confirm_message + "Seals were not confirmed\\n";
            }

            if (boxes_confirmation.contains("NO")) {
                non_confirm++;
                non_confirm_message = non_confirm_message + "Boxes were not confirmed\\n";
            }

            String response_message = "";


            if (non_confirm > 0) {
                response_message = "Some resources were not confirmed\\n";
                response_message = response_message + non_confirm_message;
                return "{\"error\":\" Operation Ref No: " + PO.getReference_number() + " - " + response_message + "\"}";
            } else {
                response_message = "All required resources successfully confirmed";
                return "{\"success\":\" Operation Ref No: " + PO.getReference_number() + " - " + response_message + "\"}";
            }


            // return "{\"success\":\"Test response\"}";
        } catch (Exception ex) {
            System.out.println("Error:\n" + ex.toString());

            return "{\"error\":\"" + ex.toString() + " at confirmJourneyResources\"}";
        }

    }


    @ResponseBody
    @RequestMapping("/startjourney")
    public String startJourney(@RequestParam("id") String id) {
        /* Start journey */
        try {
            System.out.println("START JOURNEY ID: " + id);
            System.out.println("Confirm resourses test::\n OK");
            List<PlanningAndOperations> PlanningAndOperationsList = planningAndOperationsRepo.getSingleOperationByID(id);
            System.out.println(PlanningAndOperationsList.size() + " Operations found");
            PlanningAndOperations PO = PlanningAndOperationsList.get(0);

            PO.setPlan_operation_stage("OPERATIONS");
            PO.setPlan_operation_status("STARTED");

            planningAndOperationsRepo.save(PO);

            String ref_no = PO.getReference_number();

            return "{\"success\":\"Journey Ref No: " + ref_no + " Started\"}";
        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at startJourney\"}";
        }
    }

    @ResponseBody
    @RequestMapping("/gettripentries")
    public String getTripEntries(@RequestParam("id") String id) {
        /* Start journey */
        try {
            System.out.println("PLAN/OPERATION ID: " + id);

            List<PlanningTripEntries> planningTripEntriesList = planningTripEntriesRepo.getPlanningTripByEntrriesByPlanningIDASC(id);
            System.out.println("<<<<<<<<<<Entries Found>>>>>>>> " + planningTripEntriesList.size() + " Trip Entries Found");

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
        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at gettripentries";
        }
    }

    @ResponseBody
    @RequestMapping("/sendprearrivalnotification")
    public String sendPrearrivalNotification(@RequestParam("customer_representative_id") String customer_rep_id,
                                             @RequestParam("reference_number") String reference_number) {
        /* Send prearrival notification */
        try {

            System.out.println(">>>>>Customer Rep ID: " + customer_rep_id);
            System.out.println(">>>>>OP ref no:: " + reference_number);

            CustomerRepresentative CR = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_rep_id);

            String mobile_phone = CR.getMobileNumber();
            String customer_repnames = CR.getCustomerRepresentativeName();

            String message = "Attention " + customer_repnames + ", This is a pre-arrival notification for operation ref. " + reference_number + " from the SGA CIT team. Please be aware we may arrive at your premises within the next 20 minutes";
            communication.sendSMS(mobile_phone, message);

            System.out.println(">>>>>Mobile Phone: " + mobile_phone);
            System.out.println(">>>>>Message: " + message);

            String mobile_phone_1 = mobile_phone.substring(0, 4);
            String mobile_phone_2 = mobile_phone.substring(mobile_phone.length() - 3, 10);
            String final_mobile_phone = mobile_phone_1 + "***" + mobile_phone_2;


            return "{\"success\":\"Pre-arrival message has been sent to " + customer_repnames + " via " + final_mobile_phone + "\"}";

        } catch (Exception ex) {
            return ex.toString();
        }
    }

    @ResponseBody
    @RequestMapping("/sendarrivalnotification")
    public String sendArrivalNotification(@RequestParam("customer_representative_id") String customer_rep_id,
                                          @RequestParam("reference_number") String reference_number) {
        /* Send prearrival notification */
        try {

            System.out.println(">>>>>Customer Rep ID: " + customer_rep_id);
            System.out.println(">>>>>OP ref no:: " + reference_number);

            CustomerRepresentative CR = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_rep_id);

            String mobile_phone = CR.getMobileNumber();
            String customer_repnames = CR.getCustomerRepresentativeName();

            String message = "Attention " + customer_repnames + ", This is an arrival notification for operation ref. " + reference_number + " from the SGA CIT team. We are now at your premises";
            communication.sendSMS(mobile_phone, message);

            System.out.println(">>>>>Mobile Phone: " + mobile_phone);
            System.out.println(">>>>>Message: " + message);

            String mobile_phone_1 = mobile_phone.substring(0, 4);
            String mobile_phone_2 = mobile_phone.substring(mobile_phone.length() - 3, 10);
            String final_mobile_phone = mobile_phone_1 + "***" + mobile_phone_2;


            return "{\"success\":\"Arrival message has been sent to " + customer_repnames + " via " + final_mobile_phone + "\"}";

        } catch (Exception ex) {
            return ex.toString();
        }
    }


    @ResponseBody
    @RequestMapping("/scanlocationtag")
    public String sendArrivalNotification(@RequestParam("plan_id") String plan_id,
                                          @RequestParam("customer_request_id") String customer_request_id,
                                          @RequestParam("user_id") String user_id,
                                          @RequestParam("location_tag") String location_tag,
                                          @RequestParam("action") String action
    ) {
        /* Send prearrival notification */
        try {
            //         System.out.println(">>>>>Customer Rep ID: "+customer_rep_id);
            //        System.out.println(">>>>>OP ref no:: "+reference_number);

            if (location_tag.equals(this.getLocationTagFromCustomerRequest(customer_request_id, action, location_tag))) {
                return "{\"success\":\"Location tag confirmed successfully\"}";
            } else {
                return "{\"error\":\"Location tag does not match expected location\"}";
            }

        } catch (Exception ex) {
            return ex.toString();
        }
    }


    private String getLocationTagFromCustomerRequest(String customer_request_id, String action, String sent_location_tag) {
        try {
            System.out.println("Customer request id>>>>>>>>>>>>" + customer_request_id);

            CustomerRequest CRQ = customerRequestRepo.getSingleCustomerRequestByID(customer_request_id);
//            String location_tag ="";
            String required_cust_id = "";
            String required_cust_branch_id = "";
            switch (action) {
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

            System.out.println("=========== Required Customer ID ========= " + required_cust_id);
            System.out.println("=========== Required Branch ID ========= " + required_cust_branch_id);


            LocationTags LCT = locationTagsRepo.getSingleLocationTagbByCustomerBranch(required_cust_id, required_cust_branch_id);
            String TAG_location = LCT.getCode(); //.toString();

            System.out.println("APP Location Tag>>>>>>>>>>: " + sent_location_tag + "\n");
            System.out.println("DB Location Tag>>>>>>>>>>: " + TAG_location + "\n");

            return LCT.getCode();
        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at getLocationTagFromCustomeRequest \"}";

        }
    }


    @ResponseBody
    @RequestMapping("/sendcustomerlocationotp")
    public String sendCustomerLocationOTP(@RequestParam("plan_id") String id,
                                          @RequestParam("customer_request_id") String customer_request_id,
                                          @RequestParam("customer_representative_id") String customer_representative_id,
                                          @RequestParam("customer_representative_name") String customer_representative_name,
                                          @RequestParam("user_id") String user_id
    ) {
        System.out.println("Customer Rep ID: " + customer_representative_id + "\n");
        /* Send CustomerOTP */

        String mobile = "";
        String otp_response = "";
        try {
//                CustomerManagement customerManagement = new CustomerManagement();
            CustomerRepresentative CREP = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_representative_id);
            System.out.println("Customer Representative Name: >> " + CREP.getCustomerRepresentativeName());
            mobile = CREP.getMobileNumber();
            // mobile = customerManagement.getCustomerRepMobile(customer_representative_id);
            System.out.println("mobile: " + mobile + "\n");

            otp_response = this.generateOTP(mobile, "", user_id, "CIT CREW ARRIVAL CONFIRMATION", "2");

            return otp_response;
        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at sendCustomerLocationOTP \"}";

        }
    }


    @ResponseBody
    @RequestMapping("/sendexchangeotp")
    public String sendExchangeLocationOTP(@RequestParam("plan_id") String id,
                                          @RequestParam("customer_request_id") String customer_request_id,
                                          @RequestParam("customer_representative_id") String customer_representative_id,
                                          @RequestParam("customer_representative_name") String customer_representative_name,
                                          @RequestParam("user_id") String user_id,
                                          @RequestParam("exchange_type") String exchange_type
    ) {
        System.out.println("Customer Rep ID: " + customer_representative_id + "\n");
        /* Send CustomerOTP */

        String mobile = "";
        String otp_response = "";
        try {
//                CustomerManagement customerManagement = new CustomerManagement();
            CustomerRepresentative CREP = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_representative_id);
            System.out.println("Customer Representative Name: >> " + CREP.getCustomerRepresentativeName());
            mobile = CREP.getMobileNumber();
            // mobile = customerManagement.getCustomerRepMobile(customer_representative_id);
            System.out.println("mobile: " + mobile + "\n");

            otp_response = this.generateOTP(mobile, "", user_id, "CIT EXCHANGE OTP " + exchange_type, "2");

            return otp_response;
        } catch (Exception ex) {
            System.out.println("Error\n" + ex.toString());
            return "{\"error\":\"" + ex.toString() + " at sendCustomerLocationOTP \"}";

        }
    }


    @ResponseBody
    @RequestMapping("/exchangeconsigmnentscanseals")
    public String exchangeConsignmentsScanSeals(@RequestParam("plan_id") String plan_id,
                                                @RequestParam("sealsdata") String sealsdata,
                                                @RequestParam("user_id") String user_id
    ) {
        try {

            System.out.println("Checking Seals Scanned\n");
            System.out.println("Seals Scanned - \n");
            System.out.println(sealsdata + "\n");
            System.out.println("Plan ID - \n");
            System.out.println(plan_id + "\n");
            System.out.println("User ID - \n");
            System.out.println(user_id + "\n");


            String new_seals_data = "";
            int itemsfound = 0;
            int items_not_found = 0;
            String items_not_found_string = "";

            int sealscount = StringUtils.countOccurrencesOf(sealsdata, "--");

            System.out.println("Seals count: " + sealscount + "\n\n");

            int counted_seals = 0;
            if (sealscount > 0) {

                String[] seals_to_search = sealsdata.split("--");

                counted_seals = seals_to_search.length;

                for (int x = 0; x < counted_seals; x++) {

                    String searchable = "%[" + seals_to_search[x] + "]%";

                    System.out.println("<<<<<<<<<<<SEARCHING " + searchable + "  >>>>>>>>>>>>>>>");
                    List<PlanningAndOperations> cplanningAndOperations = planningAndOperationsRepo.checkPlanScannedSealsEach(plan_id, searchable);
                    if (cplanningAndOperations.size() == 1) {
                        System.out.println(">>>>>>>>>>>>>This item has been found: " + searchable + "\n");
                        itemsfound++;
                    } else {
                        items_not_found_string = items_not_found_string + seals_to_search[x] + " ";
                        items_not_found++;
                        System.out.println("<<<<<<<<<<<<<<Seal " + seals_to_search[x] + " Not found...\n");
                    }

                }
            }

            System.out.println("ITEMS NOT FOUND -// " + items_not_found + "//\n");
            System.out.println(items_not_found_string + "\n");


         /*   if (sealsdata.length() > 4)
            {
                new_seals_data= sealsdata.replace("$", "],[");
                new_seals_data = "["+new_seals_data+"]";
            }
           */

            PlanningAndOperations SingleplanningAndOperations = planningAndOperationsRepo.getSingleOperationByIDSingleObject(plan_id);

            String seals_in_db = SingleplanningAndOperations.getSeals_serials();

            String[] seals_in_db_array = seals_in_db.replace("],[", ",").replace("[", "").replace("]", "").split(",");
            int dbsealcount_inc = 0;
            int dbsealcount_inc_missing = 0;
            String dbseals_missing = "";
            for (String s : seals_in_db_array) {
                System.out.println("DB SEAL " + s + " vs Seal data: " + sealsdata + "\n");

                int dbsealcount = StringUtils.countOccurrencesOf(sealsdata, s);
                if (dbsealcount == 1) {
                    System.out.println("DB MATCH FOR: " + s + "\n");
                    dbsealcount_inc++;
                } else {
                    System.out.println("!!! NO DB MATCH FOR: " + s + "\n");
                    dbsealcount_inc_missing++;
                    dbseals_missing = dbseals_missing + " " + s;
                }
            }

            System.out.println("Seals Count: " + sealscount + "vs dbsealcount_inc " + dbsealcount_inc + "\n");


            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            HashMap<String, String> myresponse = new HashMap<>();

            String fail_message = "";

            if (sealscount > 0 && itemsfound == counted_seals && dbsealcount_inc_missing == 0) {
                myresponse.put("SEALS_SCAN_STATUS", "SUCCESS");
                String jsonStr = mapper.writeValueAsString(myresponse);
                System.out.println("REPLY: " + jsonStr);
                return jsonStr;  // jsonStr;
            } else {

                if (items_not_found > 0) {
                    fail_message = fail_message + " This journey does not have the following Seals " + items_not_found_string;
                    ;
                }
                if (dbsealcount_inc_missing > 0) {
                    fail_message = fail_message + " You are missing " + dbseals_missing + " ";
                }
                myresponse.put("SEALS_SCAN_STATUS", "FAIL:  " + fail_message);
                String jsonStr = mapper.writeValueAsString(myresponse);
                System.out.println("REPLY: " + jsonStr);
                return jsonStr;  // jsonStr;
            }

        } catch (Exception ex) {
            return "{\"error\":\"" + ex.toString() + " at ConfirmCustomerLocationOTP\"}";
        }
    }


    @ResponseBody
    @RequestMapping("/confirmcustomerlocationotp")
    public String confirmCustomerLocationOTP(@RequestParam("plan_id") String id,
                                             @RequestParam("customer_request_id") String customer_request_id,
                                             @RequestParam("customer_representative_id") String customer_representative_id,
                                             @RequestParam("customer_representative_name") String customer_representative_name,
                                             @RequestParam("user_id") String user_id,
                                             @RequestParam("otp_reply") String otp_reply
    ) {
        try {

            System.out.println("Confirming OTP\n");
            List<SystemOtp> systemOtpList = systemOtpRepo.searchLastOtpByRecieverUserID(user_id);
            SystemOtp systemotp_single = systemOtpList.get(0); //.getOtpCode().toString();

            if (systemotp_single.getOtpCode().equals(otp_reply) && systemotp_single.getStatus().equals("PENDING")) {
                systemotp_single.setOtpCodeReply(otp_reply);
                systemotp_single.setStatus("SUCCESS");
                systemOtpRepo.save(systemotp_single);

            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            HashMap<String, String> myresponse = new HashMap<>();
            myresponse.put("OTP_CONFIRM_STATUS", "SUCCESS");
            String jsonStr = mapper.writeValueAsString(myresponse);
            System.out.println("REPLY: " + jsonStr);

            return jsonStr;  // jsonStr;

        } catch (Exception ex) {
            return "{\"error\":\"" + ex.toString() + " at ConfirmCustomerLocationOTP\"}";
        }
    }


    public String generateOTP(String mobile, String email, String user_id, String context, String expire_minutes) {
        try {

            Random rnd = new Random();
            int otp_code = 10000 + rnd.nextInt(90000);
            System.out.println("Random no generated: " + otp_code);

            SystemOtp systemOtp = new SystemOtp(Integer.toString(otp_code), "00000", "SMS", mobile, email, context, "pending", Integer.parseInt(user_id));
/*            systemOtp.setOtpCode(Integer.toString(otp_code));
            systemOtp.setOtpCodeReply("00000");
            systemOtp.setContext("FIELD_USER_LOGIN");
            systemOtp.setReceiverUserId(Integer.parseInt(user_id));
            systemOtp.setSendMode("MOBILE");
            systemOtp.setSendToEmail(email);
            systemOtp.setSendToMobile(mobile);
            systemOtp.setStatus("PENDING");*/
            systemOtpRepo.save(systemOtp);


            String message = "<#> Your CIT OTP Code for " + context + " is " + Integer.toString(otp_code);
            message = message + ". It will expire in " + expire_minutes + " minute(s)";

            Communication communication = new Communication();
            communication.sendSMS(mobile, message);
            HashMap<String, String> myresponse = new HashMap<>();

            myresponse.put("OTP_STATUS", "SUCCESS");
            myresponse.put("OTP_GENERATED", Integer.toString(otp_code));

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonStr = mapper.writeValueAsString(myresponse);
            return jsonStr;

        } catch (Exception ex) {
            return "{\"error\":\"" + ex.toString() + "  at generateOTP \"}";
        }
    }


    @ResponseBody
    @RequestMapping("/reviewprintconsigmentdocuments")
    private String reviewPrintConsignmentDocument(@RequestParam("plan_id") String plan_id,
                                                  @RequestParam("customer_request_id") String customer_request_id,
                                                  @RequestParam("planning_trip_entry_id") String planning_trip_entry_id,
                                                  @RequestParam("user_id") String user_id,
                                                  @RequestParam("exchange_type") String exchange_type
    ) {
        try {

            System.out.println("Plan ID: " + plan_id);
            System.out.println("Customer Request ID: " + customer_request_id);
            System.out.println("User Id: " + user_id);
            System.out.println("exchange_type: " + exchange_type);


            String document_number = "";
            PlanningTripEntriesDocuments PTED = planningTropEntriesDocumentsRepo.checkIfDocumentExists(plan_id, customer_request_id, planning_trip_entry_id, exchange_type);

            if (PTED == null) {
                try {
                    System.out.println("This does not exits...");
                    // Get the document and display
                    PlanningTripEntriesDocuments PTED2 = new PlanningTripEntriesDocuments(plan_id, customer_request_id, planning_trip_entry_id, "Consignment " + exchange_type, "", user_id, exchange_type, "");
                    planningTropEntriesDocumentsRepo.save(PTED2);
                    document_number = plan_id + "-" + customer_request_id + "-" + planning_trip_entry_id +"-" + Integer.toString(PTED2.getId());

                    PTED2.setDocument_number(document_number);

                    planningTropEntriesDocumentsRepo.save(PTED2);
                }
                catch (Exception ex)
                {
                    System.out.println("ERROR CREATE NEW RECORD: " + ex.toString());
                }
            } else {
                System.out.println("Record exists...");
                document_number = PTED.getDocument_number();
                exchange_type = PTED.getDocument_name();
                customer_request_id = PTED.getCustomer_request_id();
                user_id = PTED.getAudit_trail_user_id();


            }
            HashMap<String, String> myresponse = new HashMap<>();
            myresponse.put("document_number", document_number);
            myresponse.put("exchange_type", exchange_type);
            CustomerRequest CR = customerRequestRepo.getSingleCustomerRequestByID(customer_request_id);
            myresponse.put("customer_name", CR.getCustomerName());
            String branch = "";
            String customer_branch_id = CR.getCustomerBranchId();
            String customer_branch = "N/A";
            CustomerBranch CB = customerBranchRepo.getSingleCustomerBranch(customer_branch_id);

            if (CB != null) {
                customer_branch = CB.getBranch_name();
            }
            myresponse.put("branch", customer_branch);
            SystemUsers SUS = systemUsersRepo.getSingleSystemUser(user_id);
            String crew_commander_name = "";
            if (SUS != null) {
                crew_commander_name = SUS.getFirstname() + " " + SUS.getLastname();
            }
            myresponse.put("crew_commander_name", crew_commander_name);


            // Planning trip
            // REQUIRED: Document No
            // Exchange Type
            // Customer
            // Branch
            // Seals
            // Boxes
            // Crew commander name
            // myresponse.put("OTP_STATUS","SUCCESS");
            // myresponse.put("OTP_GENERATED",Integer.toString(otp_code));

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonStr = mapper.writeValueAsString(myresponse);
            return jsonStr;

        } catch (Exception ex) {
            fileManager.writeToFile("operations_errors.txt",true, ex.toString() + " at reviewPrintConsignmentDocument");
            return "{\"error\":\"" + ex.toString() + "  at reviewPrintConsignmentDocument \"}";
        }
    }


    @ResponseBody
    @RequestMapping("/reviewjourneyevents")
    public String reviewJourneyEvents(@RequestParam("plan_id") String plan_id,
                                      @RequestParam("user_id") String user_id)
    {
        try{
            // 1. Get all customer requests in the journey
                List<PlanningTripEntries> Pentries=  planningTripEntriesRepo.getPlanningTripByEntrriesByPlanningIDASC(plan_id);
                System.out.println("Planning trip entries found: "+Pentries.size());
                List<HashMap<String, String>> myoutput = new ArrayList<>();

                int event_no = 1;
                for(PlanningTripEntries pe: Pentries)
                    {
                        HashMap<String, String> output = new HashMap<>();
                        output.put("EVENT NO.", Integer.toString(event_no));
                        output.put("CUSTOMER",pe.getCustomer_name());
                        output.put("EVENT",pe.getAction());
                        output.put("STATUS",pe.getStatus());
                        myoutput.add(output);
                    }



            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonStr = mapper.writeValueAsString(myoutput);
            return jsonStr;
        }
        catch (Exception ex)
        {
            fileManager.writeToFile("operations_errors.txt",true, ex.toString()+ " at reviewJourneyEvents") ;
            return "{\"error\":\"" + ex.toString() + "  at reviewJourneyEvents \"}";

        }
    }

    @ResponseBody
    @RequestMapping("/reviewjourneydocuments")
    public String reviewJourneyDocuments(@RequestParam("plan_id") String plan_id,
                                      @RequestParam("user_id") String user_id)
    {
        try{
            List<PlanningTripEntriesDocuments> PentriesDocs=  planningTropEntriesDocumentsRepo.getDocumentsByPlanID(plan_id);
            System.out.println("Planning trip entries found: "+PentriesDocs.size());
            List<HashMap<String, String>> myoutput = new ArrayList<>();

            int event_no = 1;
            for(PlanningTripEntriesDocuments pe: PentriesDocs)
            {
                HashMap<String, String> output = new HashMap<>();
                output.put("DOCUMENT NO.", Integer.toString(event_no));
                output.put("TITLE",pe.getDocument_title());
                output.put("PATH",pe.getDocument_path());
                String cust_name="--";

                CustomerRequest CRt = customerRequestRepo.getSingleCustomerRequestByID(pe.getCustomer_request_id());

                if (CRt != null)
                {
                    cust_name = CRt.getCustomerName();
                }

                output.put("CUSTOMER_NAME", cust_name);
                myoutput.add(output);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String jsonStr = mapper.writeValueAsString(myoutput);
            return jsonStr;
        }
        catch (Exception ex)
        {
            fileManager.writeToFile("operations_errors.txt",true, ex.toString()+ " at reviewJourneyDocuments") ;
            return "{\"error\":\"" + ex.toString() + "  at reviewJourneyDocuments \"}";
        }
    }

    @ResponseBody
    @RequestMapping("/requestdecrew")
    public String requestdecrew(@RequestParam("plan_id") String plan_id,
                                         @RequestParam("user_id") String user_id)
    {
        try{

                PlanningAndOperations PO = planningAndOperationsRepo.getSingleOperationByIDObj(plan_id);


                if (PO != null)
                {

                    PO.setDecrew_requested("REQUESTED");


                    return "{\"REQUEST_DECREW\":\"SUCCESS\"}";
                }
                else {
                    PO.setDecrew_requested("REQUESTED");
                    return "{\"REQUEST_DECREW\":\"ERROR: PLANNING RECORD NOT FOUND\"}";

                }
        }
        catch (Exception ex)
        {
            fileManager.writeToFile("operations_errors.txt",true, ex.toString()+ " at reviewJourneyDocuments") ;
            return "{\"error\":\"" + ex.toString() + "  at reviewJourneyDocuments \"}";
        }
    }

}
