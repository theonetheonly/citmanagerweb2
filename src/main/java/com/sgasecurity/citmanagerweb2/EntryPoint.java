package com.sgasecurity.citmanagerweb2;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Controller
public class EntryPoint {

    @Autowired
    PlanningAndOperationsRepo planningAndOperationsRepo;
    @Autowired
    SystemUsersRepo systemUsersRepo;
    @Autowired
    SystemLoginHistoryRepo systemLoginHistoryRepo;
    @Autowired
    SystemOtpRepo systemOtpRepo;


    @ResponseBody
    @RequestMapping("/")
    public String Home() {
        return "it works";
    }


    @ResponseBody
    @RequestMapping("/mobilelogin")
    public String mobileLogin(@RequestParam("mobile") String mobile,
                              @RequestParam("password") String password,
                              @RequestParam("rfid_nfc_tag") String rfid_nfc_tag
                              ) {
        try {


            System.out.println("Mobile: "+ mobile+"\n");
            System.out.println("Password: "+ password+"\n");
            System.out.println("RFID/NFC tag: "+rfid_nfc_tag+"\n");

/*            JSONObject JOBJECT = new JSONObject(payload);

            Iterator keys = JOBJECT.keys();

            while (keys.hasNext()) {
                System.out.println("KEY :" + (String) keys.next());
            }
*/
            // {"mobile":"0725834359","password":"999888","rfid_nfc_tag":""}

  /*          String mobile = JOBJECT.get("mobile").toString();
            String password = JOBJECT.get("password").toString();
            String rfid_nfc_tag = JOBJECT.get("rfid_nfc_tag").toString();
*/
            if (mobile.length() >= 9 && password.length() >= 6) {
                //
                List<SystemUsers>   systemUsersList = systemUsersRepo.loginWithPhoneAndPassword(mobile, password);
                if(systemUsersList.size()>0) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    SystemLoginHistory systemLoginHistory = new SystemLoginHistory();
                    systemLoginHistory.setLogin_device_id("1");
                    systemLoginHistory.setLogin_event("event");
                    systemLoginHistory.setLogin_application_type("MOBILE");
                    systemLoginHistory.setLogin_session_details("login session details");
                    systemLoginHistory.setUser_id(systemUsersList.get(0).getId().toString());
                    systemLoginHistory.setLogin_device_user_agent("user_agent");
                    systemLoginHistory.setStatus("SUCCESS");
                    systemLoginHistory.setLogin_device_remote_address("Remote address");
                    systemLoginHistoryRepo.save(systemLoginHistory);

                    String jsonStr = mapper.writeValueAsString(systemUsersList);
                    return jsonStr;
                }
                else{
                    return "{\"ERROR\":\"NO SUCH USER FOUND\"}";
                }

                }
            else if (rfid_nfc_tag.length() >= 5)
            {
                List<SystemUsers>   systemUsersList = systemUsersRepo.loginWithNFCCard(rfid_nfc_tag);
                if(systemUsersList.size()>0) {
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.enable(SerializationFeature.INDENT_OUTPUT);

                    SystemLoginHistory systemLoginHistory = new SystemLoginHistory();
                    systemLoginHistory.setLogin_device_id("1");
                    systemLoginHistory.setLogin_event("event");
                    systemLoginHistory.setLogin_application_type("MOBILE");
                    systemLoginHistory.setLogin_session_details("login session details");
                    systemLoginHistory.setUser_id(systemUsersList.get(0).getId().toString());
                    systemLoginHistory.setLogin_device_user_agent("user_agent");
                    systemLoginHistory.setStatus("SUCCESS");
                    systemLoginHistory.setLogin_device_remote_address("Remote address");
                    systemLoginHistoryRepo.save(systemLoginHistory);

                    String jsonStr = mapper.writeValueAsString(systemUsersList);
                    return jsonStr;
                }
                else
                {
                    return "{\"ERROR\":\"NO SUCH USER FOUND\"}";
                }
            }
            else {
                return "{\"ERROR\":\"INVALID LOGIN DETAILS\"}";
            }

            // {"mobile":"0725834359","password":"999888","rfid_nfc_tag":""}
        } catch (Exception ex) {
            return "{\"error\":\"" + ex.toString() + "\"}";

        }
    }

    @ResponseBody
    @RequestMapping("/requestotp")
    public String requestOtp(@RequestParam("id") String user_id,
                              @RequestParam("mobile") String mobile,
                              @RequestParam("email") String email,
                              @RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname,
                              @RequestParam("context") String context
    ) {
        try {

            Random rnd = new Random();
            int otp_code = 10000+rnd.nextInt(90000);
            System.out.println("Random no generated: "+otp_code);

            SystemOtp systemOtp= new SystemOtp(Integer.toString(otp_code), "00000","SMS",mobile,email,"FIELD USER LOGIN","pending",Integer.parseInt(user_id));
/*            systemOtp.setOtpCode(Integer.toString(otp_code));
            systemOtp.setOtpCodeReply("00000");
            systemOtp.setContext("FIELD_USER_LOGIN");
            systemOtp.setReceiverUserId(Integer.parseInt(user_id));
            systemOtp.setSendMode("MOBILE");
            systemOtp.setSendToEmail(email);
            systemOtp.setSendToMobile(mobile);
            systemOtp.setStatus("PENDING");*/
             systemOtpRepo.save(systemOtp);


            String message ="<#> Your CIT OTP Code is "+Integer.toString(otp_code);
            message = message + ". It will expire in 1 minute";

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
            return "{\"error\":\"" + ex.toString() + "\"}";
        }
    }


    @ResponseBody
    @RequestMapping("/confirmotp")
    public String confirmOtp(@RequestParam("id") String user_id,
                             @RequestParam("mobile") String mobile,
                             @RequestParam("otp_code_reply") String otp_code_reply,
                             @RequestParam("otp_mobile_time") String otp_mobile_time
    ) {
        try {

            System.out.println("Confirming OTP\n");
            List<SystemOtp> systemOtpList = systemOtpRepo.searchLastOtpByRecieverUserID(user_id);
            SystemOtp systemotp_single  = systemOtpList.get(0); //.getOtpCode().toString();

            if (systemotp_single.getOtpCode().equals(otp_code_reply) && systemotp_single.getStatus().equals("PENDING")) {
                    systemotp_single.setOtpCodeReply(otp_code_reply);
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
            return "{\"error\":\"" + ex.toString() + "\"}";
        }
    }


}



