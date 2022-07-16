package com.sgasecurity.citmanagerweb2.resources;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class LocationTags {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue

    private int id;
    private String update_timestamp;
    private String code;
    private String location_tag_type;
    private String location_coordinates;
    private String customer_id;
    private String customer_branch_id;
    private String status;

    public LocationTags()
    {

    }
    public LocationTags(String update_timestamp, String code, String location_tag_type, String location_coordinates, String customer_id, String customer_branch_id, String status, String audit_trail_user_id, String timestamp) {
        this.update_timestamp = update_timestamp;
        this.code = code;
        this.location_tag_type = location_tag_type;
        this.location_coordinates = location_coordinates;
        this.customer_id = customer_id;
        this.customer_branch_id = customer_branch_id;
        this.status = status;
        this.audit_trail_user_id = audit_trail_user_id;
        this.timestamp = timestamp;
    }

    private String audit_trail_user_id;
    private String timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation_tag_type() {
        return location_tag_type;
    }

    public void setLocation_tag_type(String location_tag_type) {
        this.location_tag_type = location_tag_type;
    }

    public String getLocation_coordinates() {
        return location_coordinates;
    }

    public void setLocation_coordinates(String location_coordinates) {
        this.location_coordinates = location_coordinates;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_branch_id() {
        return customer_branch_id;
    }

    public void setCustomer_branch_id(String customer_branch_id) {
        this.customer_branch_id = customer_branch_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAudit_trail_user_id() {
        return audit_trail_user_id;
    }

    public void setAudit_trail_user_id(String audit_trail_user_id) {
        this.audit_trail_user_id = audit_trail_user_id;
    }



}
