package com.sgasecurity.citmanagerweb2.customermanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class CustomerBranch {


    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue

    private int id;
    private String timestamp;
    private String update_timestamp;
    private String customer_id;


    private String branch_name;
    private String branch_code;
    private String physical_address;
    private String branch_latitude;
    private String branch_longitude;
    private String postal_address;
    private String branch_telephone;
    private String branch_email;


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUpdate_timestamp() {
        return update_timestamp;
    }

    public void setUpdate_timestamp(String update_timestamp) {
        this.update_timestamp = update_timestamp;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getPhysical_address() {
        return physical_address;
    }

    public void setPhysical_address(String physical_address) {
        this.physical_address = physical_address;
    }

    public String getBranch_latitude() {
        return branch_latitude;
    }

    public void setBranch_latitude(String branch_latitude) {
        this.branch_latitude = branch_latitude;
    }

    public String getBranch_longitude() {
        return branch_longitude;
    }

    public void setBranch_longitude(String branch_longitude) {
        this.branch_longitude = branch_longitude;
    }

    public String getPostal_address() {
        return postal_address;
    }

    public void setPostal_address(String postal_address) {
        this.postal_address = postal_address;
    }

    public String getBranch_telephone() {
        return branch_telephone;
    }

    public void setBranch_telephone(String branch_telephone) {
        this.branch_telephone = branch_telephone;
    }

    public String getBranch_email() {
        return branch_email;
    }

    public void setBranch_email(String branch_email) {
        this.branch_email = branch_email;
    }

}
