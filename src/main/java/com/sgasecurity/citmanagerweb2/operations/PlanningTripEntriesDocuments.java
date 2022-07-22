package com.sgasecurity.citmanagerweb2.operations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class PlanningTripEntriesDocuments {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue

    private int id;
    private String timestamp;
    private String update_timestamp;
    private String planning_id;
    private String customer_request_id;
    private String planning_trip_entry_id;
    private String document_title;
    private String document_path;
    private String audit_trail_user_id;

    private  String document_name;

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    private  String document_number;

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

    public String getPlanning_trip_entry_id() {
        return planning_trip_entry_id;
    }

    public void setPlanning_trip_entry_id(String planning_trip_entry_id) {
        this.planning_trip_entry_id = planning_trip_entry_id;
    }

    public String getDocument_title() {
        return document_title;
    }

    public void setDocument_title(String document_title) {
        this.document_title = document_title;
    }

    public String getDocument_path() {
        return document_path;
    }

    public void setDocument_path(String document_path) {
        this.document_path = document_path;
    }

    public String getAudit_trail_user_id() {
        return audit_trail_user_id;
    }

    public void setAudit_trail_user_id(String audit_trail_user_id) {
        this.audit_trail_user_id = audit_trail_user_id;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public PlanningTripEntriesDocuments()
   {

   }

    public PlanningTripEntriesDocuments(String planning_id, String customer_request_id, String planning_trip_entry_id, String document_title, String document_path, String audit_trail_user_id, String document_name, String document_number) {
       // this.timestamp = timestamp;
        // this.update_timestamp = update_timestamp;
        this.planning_id = planning_id;
        this.customer_request_id = customer_request_id;
        this.planning_trip_entry_id = planning_trip_entry_id;
        this.document_title = document_title;
        this.document_path = document_path;
        this.audit_trail_user_id = audit_trail_user_id;
        this.document_name = document_name;
        this.document_number = document_number;
    }


}
