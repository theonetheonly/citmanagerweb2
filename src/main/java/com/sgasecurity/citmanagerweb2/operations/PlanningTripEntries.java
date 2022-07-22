package com.sgasecurity.citmanagerweb2.operations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class PlanningTripEntries {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;


    private String timestamp;
    private String update_timestamp;
    private String planning_id;
    private String customer_request_id;
    private String location_name;
    private String location_coordinates;
    private String status;

    private String action;

    private String service_name;

    private String time_required;

    private String customer_name;

    private String customer_representative_name;

    private String customer_id;


    private String customer_representative_id;


    public String getCustomer_representative_name() {
        return customer_representative_name;
    }

    public void setCustomer_representative_name(String customer_representative_name) {
        this.customer_representative_name = customer_representative_name;
    }




    public PlanningTripEntries()
    {

    }
    public PlanningTripEntries(String timestamp, String update_timestamp, String planning_id, String customer_request_id, String location_name, String location_coordinates, String status, String action, String service_name, String time_required, String customer_name, String customer_representative_name, String customer_id, String customer_representative_id) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.planning_id = planning_id;
        this.customer_request_id = customer_request_id;
        this.location_name = location_name;
        this.location_coordinates = location_coordinates;
        this.action = action;
        this.service_name = service_name;
        this.status = status;
        this.time_required = time_required;
        this.customer_name = customer_name;
        this.customer_representative_name = customer_representative_name;
        this.customer_representative_id = customer_representative_id;
        this.customer_id = customer_id;

    }
    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_representative_id() {
        return customer_representative_id;
    }

    public void setCustomer_representative_id(String customer_representative_id) {
        this.customer_representative_id = customer_representative_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPlanning_id() {
        return planning_id;
    }

    public void setPlanning_id(String planning_id) {
        this.planning_id = planning_id;
    }

    public String getCustomer_request_id() {
        return customer_request_id;
    }

    public void setCustomer_request_id(String customer_request_id) {
        this.customer_request_id = customer_request_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_coordinates() {
        return location_coordinates;
    }

    public void setLocation_coordinates(String location_coordinates) {
        this.location_coordinates = location_coordinates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getTime_required() {
        return time_required;
    }
    public void setTime_required(String time_required) {
        this.time_required = time_required;
    }

}
