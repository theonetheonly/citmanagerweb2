package com.sgasecurity.citmanagerweb2.operations;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class PlanningDecrewment {
    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    private String timestamp;
    private String update_timestamp;
    private String planning_id;
    private String time_executed;
    private String crew_commander_id;
    private String lead_vehicle_expected_id;
    private String lead_vehicle_decrewed_id;
    private String chase_vehicle_expected_id;
    private String chase_vehicle_decrewed_id;
    private String lead_driver_expected_id;
    private String lead_driver_decrewed_id;
    private String chase_driver_expected_id;
    private String chase_driver_decrewed_id;
    private String support_staff_expected_ids;
    private String support_staff_decrewed_ids;
    private String police_officers_expected_ids;
    private String police_officers_decrewed_ids;
    private String bags_boxes_expected_serials;
    private String bags_boxes_decrewed_serials;
    private String seals_expected_serials;
    private String seals_decrewed_serials;
    private String crew_commander_confirmation_otp;
    private String status;
    private String comments;
    private String decrewment_officer_id;
    private String decrewment_officer_name;
    private String audit_trail_user_id;


    public PlanningDecrewment()
    {

    }
    public PlanningDecrewment(String timestamp, String update_timestamp, String planning_id, String time_executed, String crew_commander_id, String lead_vehicle_expected_id, String lead_vehicle_decrewed_id, String chase_vehicle_expected_id, String chase_vehicle_decrewed_id, String lead_driver_expected_id, String lead_driver_decrewed_id, String chase_driver_expected_id, String chase_driver_decrewed_id, String support_staff_expected_ids, String support_staff_decrewed_ids, String police_officers_expected_ids, String police_officers_decrewed_ids, String bags_boxes_expected_serials, String bags_boxes_decrewed_serials, String seals_expected_serials, String seals_decrewed_serials, String crew_commander_confirmation_otp, String status, String comments, String decrewment_officer_id, String decrewment_officer_name, String audit_trail_user_id) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.planning_id = planning_id;
        this.time_executed = time_executed;
        this.crew_commander_id = crew_commander_id;
        this.lead_vehicle_expected_id = lead_vehicle_expected_id;
        this.lead_vehicle_decrewed_id = lead_vehicle_decrewed_id;
        this.chase_vehicle_expected_id = chase_vehicle_expected_id;
        this.chase_vehicle_decrewed_id = chase_vehicle_decrewed_id;
        this.lead_driver_expected_id = lead_driver_expected_id;
        this.lead_driver_decrewed_id = lead_driver_decrewed_id;
        this.chase_driver_expected_id = chase_driver_expected_id;
        this.chase_driver_decrewed_id = chase_driver_decrewed_id;
        this.support_staff_expected_ids = support_staff_expected_ids;
        this.support_staff_decrewed_ids = support_staff_decrewed_ids;
        this.police_officers_expected_ids = police_officers_expected_ids;
        this.police_officers_decrewed_ids = police_officers_decrewed_ids;
        this.bags_boxes_expected_serials = bags_boxes_expected_serials;
        this.bags_boxes_decrewed_serials = bags_boxes_decrewed_serials;
        this.seals_expected_serials = seals_expected_serials;
        this.seals_decrewed_serials = seals_decrewed_serials;
        this.crew_commander_confirmation_otp = crew_commander_confirmation_otp;
        this.status = status;
        this.comments = comments;
        this.decrewment_officer_id = decrewment_officer_id;
        this.decrewment_officer_name = decrewment_officer_name;
        this.audit_trail_user_id = audit_trail_user_id;
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

    public String getTime_executed() {
        return time_executed;
    }

    public void setTime_executed(String time_executed) {
        this.time_executed = time_executed;
    }

    public String getCrew_commander_id() {
        return crew_commander_id;
    }

    public void setCrew_commander_id(String crew_commander_id) {
        this.crew_commander_id = crew_commander_id;
    }

    public String getLead_vehicle_expected_id() {
        return lead_vehicle_expected_id;
    }

    public void setLead_vehicle_expected_id(String lead_vehicle_expected_id) {
        this.lead_vehicle_expected_id = lead_vehicle_expected_id;
    }

    public String getLead_vehicle_decrewed_id() {
        return lead_vehicle_decrewed_id;
    }

    public void setLead_vehicle_decrewed_id(String lead_vehicle_decrewed_id) {
        this.lead_vehicle_decrewed_id = lead_vehicle_decrewed_id;
    }

    public String getChase_vehicle_expected_id() {
        return chase_vehicle_expected_id;
    }

    public void setChase_vehicle_expected_id(String chase_vehicle_expected_id) {
        this.chase_vehicle_expected_id = chase_vehicle_expected_id;
    }

    public String getChase_vehicle_decrewed_id() {
        return chase_vehicle_decrewed_id;
    }

    public void setChase_vehicle_decrewed_id(String chase_vehicle_decrewed_id) {
        this.chase_vehicle_decrewed_id = chase_vehicle_decrewed_id;
    }

    public String getLead_driver_expected_id() {
        return lead_driver_expected_id;
    }

    public void setLead_driver_expected_id(String lead_driver_expected_id) {
        this.lead_driver_expected_id = lead_driver_expected_id;
    }

    public String getLead_driver_decrewed_id() {
        return lead_driver_decrewed_id;
    }

    public void setLead_driver_decrewed_id(String lead_driver_decrewed_id) {
        this.lead_driver_decrewed_id = lead_driver_decrewed_id;
    }

    public String getChase_driver_expected_id() {
        return chase_driver_expected_id;
    }

    public void setChase_driver_expected_id(String chase_driver_expected_id) {
        this.chase_driver_expected_id = chase_driver_expected_id;
    }

    public String getChase_driver_decrewed_id() {
        return chase_driver_decrewed_id;
    }

    public void setChase_driver_decrewed_id(String chase_driver_decrewed_id) {
        this.chase_driver_decrewed_id = chase_driver_decrewed_id;
    }

    public String getSupport_staff_expected_ids() {
        return support_staff_expected_ids;
    }

    public void setSupport_staff_expected_ids(String support_staff_expected_ids) {
        this.support_staff_expected_ids = support_staff_expected_ids;
    }

    public String getSupport_staff_decrewed_ids() {
        return support_staff_decrewed_ids;
    }

    public void setSupport_staff_decrewed_ids(String support_staff_decrewed_ids) {
        this.support_staff_decrewed_ids = support_staff_decrewed_ids;
    }

    public String getPolice_officers_expected_ids() {
        return police_officers_expected_ids;
    }

    public void setPolice_officers_expected_ids(String police_officers_expected_ids) {
        this.police_officers_expected_ids = police_officers_expected_ids;
    }

    public String getPolice_officers_decrewed_ids() {
        return police_officers_decrewed_ids;
    }

    public void setPolice_officers_decrewed_ids(String police_officers_decrewed_ids) {
        this.police_officers_decrewed_ids = police_officers_decrewed_ids;
    }

    public String getBags_boxes_expected_serials() {
        return bags_boxes_expected_serials;
    }

    public void setBags_boxes_expected_serials(String bags_boxes_expected_serials) {
        this.bags_boxes_expected_serials = bags_boxes_expected_serials;
    }

    public String getBags_boxes_decrewed_serials() {
        return bags_boxes_decrewed_serials;
    }

    public void setBags_boxes_decrewed_serials(String bags_boxes_decrewed_serials) {
        this.bags_boxes_decrewed_serials = bags_boxes_decrewed_serials;
    }

    public String getSeals_expected_serials() {
        return seals_expected_serials;
    }

    public void setSeals_expected_serials(String seals_expected_serials) {
        this.seals_expected_serials = seals_expected_serials;
    }

    public String getSeals_decrewed_serials() {
        return seals_decrewed_serials;
    }

    public void setSeals_decrewed_serials(String seals_decrewed_serials) {
        this.seals_decrewed_serials = seals_decrewed_serials;
    }

    public String getCrew_commander_confirmation_otp() {
        return crew_commander_confirmation_otp;
    }

    public void setCrew_commander_confirmation_otp(String crew_commander_confirmation_otp) {
        this.crew_commander_confirmation_otp = crew_commander_confirmation_otp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDecrewment_officer_id() {
        return decrewment_officer_id;
    }

    public void setDecrewment_officer_id(String decrewment_officer_id) {
        this.decrewment_officer_id = decrewment_officer_id;
    }

    public String getDecrewment_officer_name() {
        return decrewment_officer_name;
    }

    public void setDecrewment_officer_name(String decrewment_officer_name) {
        this.decrewment_officer_name = decrewment_officer_name;
    }

    public String getAudit_trail_user_id() {
        return audit_trail_user_id;
    }

    public void setAudit_trail_user_id(String audit_trail_user_id) {
        this.audit_trail_user_id = audit_trail_user_id;
    }


}