package com.sgasecurity.citmanagerweb2;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Communication {


    public String SMS_API_URL = "";
    public String error_msg = "";
    CommonFunctions myCommon = new CommonFunctions();

    public void sendSMS(String mobilephone, String message) throws IOException {

        try {
            this.SMS_API_URL = myCommon.getConfigValue("SMS_API_URL");
            String myurl = this.SMS_API_URL; //"http://172.105.99.106/smsapi/sendsms.php?";
            //  myCommon.printToScreen("SMS URL: "+ myurl);

            Map<String, Object> post_data = new LinkedHashMap<>();
            post_data.put("mobile", mobilephone);
            post_data.put("message", message);
            post_data.put("gatewayip", "192.168.0.1");
            post_data.put("accesscode", "4321");
            NetworkActivity networkActivity = new NetworkActivity();
            networkActivity.executeURL(myurl, post_data);
            // this.logComms(mobilephone, message, "sms");

        } catch (Exception ex) {
            error_msg = "Error: (CommonFunctions) (getConfigValue)\n" + ex.toString();
            System.out.println(error_msg);
            return;

        }
    }
}

