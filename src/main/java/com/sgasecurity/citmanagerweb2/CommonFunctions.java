package com.sgasecurity.citmanagerweb2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Random;


@Controller
public class CommonFunctions {


    @Autowired
    SystemOtpRepo  systemOtpRepo;

    String error_msg ="";

    public String getConfigValue(String config_name)
    {


        try{
            String result ="";
            switch (config_name)
            {
                case "SMS_API_URL":
                    result=  "https://comms.sgasecurity.com/sgasms/fromthirdparty_citapp.php?";

                    break;
                default:
                    result ="No selection made";
                    break;


            }

            return  result;

        }
        catch (Exception ex)
        {
            error_msg = "Error: (CommonFunctions) (getConfigValue)\n"+ex.toString();
            System.out.println(error_msg);
            return error_msg;
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
