package com.sgasecurity.citmanagerweb2.customermanagement;

import com.sgasecurity.citmanagerweb2.SystemOtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerManagement {


    @Autowired
    CustomerRepresentativeRepo customerRepresentativeRepo;

    public  String getCustomerRepMobile(String customer_rep_id)
    {
        try {
            CustomerRepresentative CREP = customerRepresentativeRepo.getSingelCustomerRepresentative(customer_rep_id);
            System.out.println("Customer Representative Name: >> " + CREP.getCustomerRepresentativeName() );
            return CREP.getMobileNumber();
        }
        catch (Exception ex)
            {
                    System.out.println("Error\n"+ex.toString());
                    return "{\"error\":\"" + ex.toString() + " at getCustomerRepMobile\"}";
            }
    }

}
