package com.sgasecurity.citmanagerweb2.vehiclemanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicles {

    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    private String timestamp;
    private String update_timestamp;
    private String vehicle_type;
    private String vehicle_make;
    private String vehicle_model;
    private String body_type;
    private String vehicle_reg_no;
    private String general_condition;
    private String general_condition_comments;
    private String last_service_date;
    private String last_service_type;
    private String last_maintenance_date;
    private String last_maintenance_type;
    private String current_fuel_level;
    private String odometer_reading;
    private String gps_status;
    private String lock_status;
    private String journey_status;
    private String status;
    private String audit_trail_user_id;

    public Vehicles() {
    }

    public Vehicles(String timestamp, String update_timestamp, String vehicle_type, String vehicle_make, String vehicle_model, String body_type, String vehicle_reg_no, String general_condition, String general_condition_comments, String last_service_date, String last_service_type, String last_maintenance_date, String last_maintenance_type, String current_fuel_level, String odometer_reading, String gps_status, String lock_status, String journey_status, String status, String audit_trail_user_id) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.vehicle_type = vehicle_type;
        this.vehicle_make = vehicle_make;
        this.vehicle_model = vehicle_model;
        this.body_type = body_type;
        this.vehicle_reg_no = vehicle_reg_no;
        this.general_condition = general_condition;
        this.general_condition_comments = general_condition_comments;
        this.last_service_date = last_service_date;
        this.last_service_type = last_service_type;
        this.last_maintenance_date = last_maintenance_date;
        this.last_maintenance_type = last_maintenance_type;
        this.current_fuel_level = current_fuel_level;
        this.odometer_reading = odometer_reading;
        this.gps_status = gps_status;
        this.lock_status = lock_status;
        this.journey_status = journey_status;
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

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    public String getVehicle_make() {
        return vehicle_make;
    }

    public void setVehicle_make(String vehicle_make) {
        this.vehicle_make = vehicle_make;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getVehicle_reg_no() {
        return vehicle_reg_no;
    }

    public void setVehicle_reg_no(String vehicle_reg_no) {
        this.vehicle_reg_no = vehicle_reg_no;
    }

    public String getGeneral_condition() {
        return general_condition;
    }

    public void setGeneral_condition(String general_condition) {
        this.general_condition = general_condition;
    }

    public String getGeneral_condition_comments() {
        return general_condition_comments;
    }

    public void setGeneral_condition_comments(String general_condition_comments) {
        this.general_condition_comments = general_condition_comments;
    }

    public String getLast_service_date() {
        return last_service_date;
    }

    public void setLast_service_date(String last_service_date) {
        this.last_service_date = last_service_date;
    }

    public String getLast_service_type() {
        return last_service_type;
    }

    public void setLast_service_type(String last_service_type) {
        this.last_service_type = last_service_type;
    }

    public String getLast_maintenance_date() {
        return last_maintenance_date;
    }

    public void setLast_maintenance_date(String last_maintenance_date) {
        this.last_maintenance_date = last_maintenance_date;
    }

    public String getLast_maintenance_type() {
        return last_maintenance_type;
    }

    public void setLast_maintenance_type(String last_maintenance_type) {
        this.last_maintenance_type = last_maintenance_type;
    }

    public String getCurrent_fuel_level() {
        return current_fuel_level;
    }

    public void setCurrent_fuel_level(String current_fuel_level) {
        this.current_fuel_level = current_fuel_level;
    }

    public String getOdometer_reading() {
        return odometer_reading;
    }

    public void setOdometer_reading(String odometer_reading) {
        this.odometer_reading = odometer_reading;
    }

    public String getGps_status() {
        return gps_status;
    }

    public void setGps_status(String gps_status) {
        this.gps_status = gps_status;
    }

    public String getLock_status() {
        return lock_status;
    }

    public void setLock_status(String lock_status) {
        this.lock_status = lock_status;
    }

    public String getJourney_status() {
        return journey_status;
    }

    public void setJourney_status(String journey_status) {
        this.journey_status = journey_status;
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