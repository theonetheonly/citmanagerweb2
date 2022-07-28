package com.sgasecurity.citmanagerweb2.incidents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Incidents {
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    private String timestamp;
    private String update_timestamp;
    private String planning_id;
    private String incident_time;
    private String reported_by_id;
    private String crew_commander_name;
    private String type;
    private String description;
    private String image;
    private String reviewed_by_id;
    private String reviewed_by_timestamp;
    private String status;
    private String audit_trail_user_id;

    public Incidents() {
    }

    public Incidents(String timestamp, String update_timestamp, String planning_id, String incident_time, String reported_by_id, String crew_commander_name, String type, String description, String image, String reviewed_by_id, String reviewed_by_timestamp, String status, String audit_trail_user_id) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.planning_id = planning_id;
        this.incident_time = incident_time;
        this.reported_by_id = reported_by_id;
        this.crew_commander_name = crew_commander_name;
        this.type = type;
        this.description = description;
        this.image = image;
        this.reviewed_by_id = reviewed_by_id;
        this.reviewed_by_timestamp = reviewed_by_timestamp;
        this.status = status;
        this.audit_trail_user_id = audit_trail_user_id;
    }

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

    public String getIncident_time() {
        return incident_time;
    }

    public void setIncident_time(String incident_time) {
        this.incident_time = incident_time;
    }

    public String getReported_by_id() {
        return reported_by_id;
    }

    public void setReported_by_id(String reported_by_id) {
        this.reported_by_id = reported_by_id;
    }

    public String getCrew_commander_name() {
        return crew_commander_name;
    }

    public void setCrew_commander_name(String crew_commander_name) {
        this.crew_commander_name = crew_commander_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReviewed_by_id() {
        return reviewed_by_id;
    }

    public void setReviewed_by_id(String reviewed_by_id) {
        this.reviewed_by_id = reviewed_by_id;
    }

    public String getReviewed_by_timestamp() {
        return reviewed_by_timestamp;
    }

    public void setReviewed_by_timestamp(String reviewed_by_timestamp) {
        this.reviewed_by_timestamp = reviewed_by_timestamp;
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
