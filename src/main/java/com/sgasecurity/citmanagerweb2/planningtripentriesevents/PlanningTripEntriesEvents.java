package com.sgasecurity.citmanagerweb2.planningtripentriesevents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class PlanningTripEntriesEvents {

    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    private String timestamp;
    private String update_timestamp;
    private String planning_id;
    private String planning_trip_entry_id;
    private String event_name;
    private String event_value;
    private String event_owner_id;
    private String event_owner_name;
    private String event_owner_type;
    private String event_status;
    private String event_comments;
    private String audit_trail_user_id;

    public PlanningTripEntriesEvents() {
    }

    public PlanningTripEntriesEvents(int id, String timestamp, String update_timestamp, String planning_id, String planning_trip_entry_id, String event_name, String event_value, String event_owner_id, String event_owner_name, String event_owner_type, String event_status, String event_comments, String audit_trail_user_id) {
        this.id = id;
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.planning_id = planning_id;
        this.planning_trip_entry_id = planning_trip_entry_id;
        this.event_name = event_name;
        this.event_value = event_value;
        this.event_owner_id = event_owner_id;
        this.event_owner_name = event_owner_name;
        this.event_owner_type = event_owner_type;
        this.event_status = event_status;
        this.event_comments = event_comments;
        this.audit_trail_user_id = audit_trail_user_id;
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

    public String getPlanning_trip_entry_id() {
        return planning_trip_entry_id;
    }

    public void setPlanning_trip_entry_id(String planning_trip_entry_id) {
        this.planning_trip_entry_id = planning_trip_entry_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_value() {
        return event_value;
    }

    public void setEvent_value(String event_value) {
        this.event_value = event_value;
    }

    public String getEvent_owner_id() {
        return event_owner_id;
    }

    public void setEvent_owner_id(String event_owner_id) {
        this.event_owner_id = event_owner_id;
    }

    public String getEvent_owner_name() {
        return event_owner_name;
    }

    public void setEvent_owner_name(String event_owner_name) {
        this.event_owner_name = event_owner_name;
    }

    public String getEvent_owner_type() {
        return event_owner_type;
    }

    public void setEvent_owner_type(String event_owner_type) {
        this.event_owner_type = event_owner_type;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public String getEvent_comments() {
        return event_comments;
    }

    public void setEvent_comments(String event_comments) {
        this.event_comments = event_comments;
    }

    public String getAudit_trail_user_id() {
        return audit_trail_user_id;
    }

    public void setAudit_trail_user_id(String audit_trail_user_id) {
        this.audit_trail_user_id = audit_trail_user_id;
    }
}
