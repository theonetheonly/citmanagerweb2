package com.sgasecurity.citmanagerweb2.operations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class PlanningAndOperations {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private String timestamp;
    private String update_timestamp;
    private String reference_number;
    private String request_type;
    private String customer_request_ids;
    private String itinerary_coordinates;
    private String crew_commander_id;
    private String crew_commander_name;
    private String support_staff_ids;
    private String support_staff_names;
    private String vehicle_preallocated_status;
    private String lead_car_id;
    private String lead_car_regno;
    private String chase_car_id;
    private String chase_car_regno;
    private String lead_car_driver_id;
    private String lead_car_driver_name;
    private String chase_car_driver_id;
    private String chase_car_driver_name;
    private String bags_boxes_serials;
    private String seals_serials;
    private String plan_operation_stage;
    private String plan_operation_status;
    private String plan_created_by_id;
    private String plan_approved_by_id;
    private String plan_created_by_name;
    private String plan_approved_by_name;
    private String police_post_name;
    private String police_post_number;
    private String police_officer_names;
    private String police_officers_numbers;
    private String number_of_police_officers;
    private String is_cross_border;
    private String police_officers_confirmation;

    private String lead_car_confirmation;
    private String chase_car_confirmation;

    private String lead_driver_confirmation;
    private String chase_driver_confirmation;
    private String support_staff_confirmation;
    private String boxbag_confirmation;
    private String seals_confirmation;
    private String events_reviewed;
    private String documents_reviewed;
    private String decrew_requested;
    private String decrew_otp_confirmed;
    private String decrew_otp_id;
    private String audit_trail_user_id;

    public PlanningAndOperations()
    {

    }

    public PlanningAndOperations(String timestamp, String update_timestamp, String reference_number, String request_type, String customer_request_ids, String itinerary_coordinates, String crew_commander_id, String crew_commander_name, String support_staff_ids, String support_staff_names, String vehicle_preallocated_status, String lead_car_id, String lead_car_regno, String chase_car_id, String chase_car_regno, String lead_car_driver_id, String lead_car_driver_name, String chase_car_driver_id, String chase_car_driver_name, String bags_boxes_serials, String seals_serials, String plan_operation_stage, String plan_operation_status, String plan_created_by_id, String plan_approved_by_id, String plan_created_by_name, String plan_approved_by_name, String police_post_name, String police_post_number, String police_officer_names, String police_officers_numbers, String number_of_police_officers, String is_cross_border, String police_officers_confirmation, String lead_car_confirmation, String chase_car_confirmation, String lead_driver_confirmation, String chase_driver_confirmation, String support_staff_confirmation, String boxbag_confirmation, String seals_confirmation, String events_reviewed, String documents_reviewed, String decrew_requested, String decrew_otp_confirmed, String decrew_otp_id, String audit_trail_user_id) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.reference_number = reference_number;
        this.request_type = request_type;
        this.customer_request_ids = customer_request_ids;
        this.itinerary_coordinates = itinerary_coordinates;
        this.crew_commander_id = crew_commander_id;
        this.crew_commander_name = crew_commander_name;
        this.support_staff_ids = support_staff_ids;
        this.support_staff_names = support_staff_names;
        this.vehicle_preallocated_status = vehicle_preallocated_status;
        this.lead_car_id = lead_car_id;
        this.lead_car_regno = lead_car_regno;
        this.chase_car_id = chase_car_id;
        this.chase_car_regno = chase_car_regno;
        this.lead_car_driver_id = lead_car_driver_id;
        this.lead_car_driver_name = lead_car_driver_name;
        this.chase_car_driver_id = chase_car_driver_id;
        this.chase_car_driver_name = chase_car_driver_name;
        this.bags_boxes_serials = bags_boxes_serials;
        this.seals_serials = seals_serials;
        this.plan_operation_stage = plan_operation_stage;
        this.plan_operation_status = plan_operation_status;
        this.plan_created_by_id = plan_created_by_id;
        this.plan_approved_by_id = plan_approved_by_id;
        this.plan_created_by_name = plan_created_by_name;
        this.plan_approved_by_name = plan_approved_by_name;
        this.police_post_name = police_post_name;
        this.police_post_number = police_post_number;
        this.police_officer_names = police_officer_names;
        this.police_officers_numbers = police_officers_numbers;
        this.number_of_police_officers = number_of_police_officers;
        this.is_cross_border = is_cross_border;
        this.police_officers_confirmation = police_officers_confirmation;
        this.lead_car_confirmation = lead_car_confirmation;
        this.chase_car_confirmation = chase_car_confirmation;
        this.lead_driver_confirmation = lead_driver_confirmation;
        this.chase_driver_confirmation = chase_driver_confirmation;
        this.support_staff_confirmation = support_staff_confirmation;
        this.boxbag_confirmation = boxbag_confirmation;
        this.seals_confirmation = seals_confirmation;
        this.events_reviewed = events_reviewed;
        this.documents_reviewed = documents_reviewed;
        this.decrew_requested = decrew_requested;
        this.decrew_otp_confirmed = decrew_otp_confirmed;
        this.decrew_otp_id = decrew_otp_id;
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

    public String getReference_number() {
        return reference_number;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }

    public String getRequest_type() {
        return request_type;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public String getCustomer_request_ids() {
        return customer_request_ids;
    }

    public void setCustomer_request_ids(String customer_request_ids) {
        this.customer_request_ids = customer_request_ids;
    }

    public String getItinerary_coordinates() {
        return itinerary_coordinates;
    }

    public void setItinerary_coordinates(String itinerary_coordinates) {
        this.itinerary_coordinates = itinerary_coordinates;
    }

    public String getCrew_commander_id() {
        return crew_commander_id;
    }

    public void setCrew_commander_id(String crew_commander_id) {
        this.crew_commander_id = crew_commander_id;
    }

    public String getCrew_commander_name() {
        return crew_commander_name;
    }

    public void setCrew_commander_name(String crew_commander_name) {
        this.crew_commander_name = crew_commander_name;
    }

    public String getSupport_staff_ids() {
        return support_staff_ids;
    }

    public void setSupport_staff_ids(String support_staff_ids) {
        this.support_staff_ids = support_staff_ids;
    }

    public String getSupport_staff_names() {
        return support_staff_names;
    }

    public void setSupport_staff_names(String support_staff_names) {
        this.support_staff_names = support_staff_names;
    }

    public String getVehicle_preallocated_status() {
        return vehicle_preallocated_status;
    }

    public void setVehicle_preallocated_status(String vehicle_preallocated_status) {
        this.vehicle_preallocated_status = vehicle_preallocated_status;
    }

    public String getLead_car_id() {
        return lead_car_id;
    }

    public void setLead_car_id(String lead_car_id) {
        this.lead_car_id = lead_car_id;
    }

    public String getLead_car_regno() {
        return lead_car_regno;
    }

    public void setLead_car_regno(String lead_car_regno) {
        this.lead_car_regno = lead_car_regno;
    }

    public String getChase_car_id() {
        return chase_car_id;
    }

    public void setChase_car_id(String chase_car_id) {
        this.chase_car_id = chase_car_id;
    }

    public String getChase_car_regno() {
        return chase_car_regno;
    }

    public void setChase_car_regno(String chase_car_regno) {
        this.chase_car_regno = chase_car_regno;
    }

    public String getLead_car_driver_id() {
        return lead_car_driver_id;
    }

    public void setLead_car_driver_id(String lead_car_driver_id) {
        this.lead_car_driver_id = lead_car_driver_id;
    }

    public String getLead_car_driver_name() {
        return lead_car_driver_name;
    }

    public void setLead_car_driver_name(String lead_car_driver_name) {
        this.lead_car_driver_name = lead_car_driver_name;
    }

    public String getChase_car_driver_id() {
        return chase_car_driver_id;
    }

    public void setChase_car_driver_id(String chase_car_driver_id) {
        this.chase_car_driver_id = chase_car_driver_id;
    }

    public String getChase_car_driver_name() {
        return chase_car_driver_name;
    }

    public void setChase_car_driver_name(String chase_car_driver_name) {
        this.chase_car_driver_name = chase_car_driver_name;
    }

    public String getBags_boxes_serials() {
        return bags_boxes_serials;
    }

    public void setBags_boxes_serials(String bags_boxes_serials) {
        this.bags_boxes_serials = bags_boxes_serials;
    }

    public String getSeals_serials() {
        return seals_serials;
    }

    public void setSeals_serials(String seals_serials) {
        this.seals_serials = seals_serials;
    }

    public String getPlan_operation_stage() {
        return plan_operation_stage;
    }

    public void setPlan_operation_stage(String plan_operation_stage) {
        this.plan_operation_stage = plan_operation_stage;
    }

    public String getPlan_operation_status() {
        return plan_operation_status;
    }

    public void setPlan_operation_status(String plan_operation_status) {
        this.plan_operation_status = plan_operation_status;
    }

    public String getPlan_created_by_id() {
        return plan_created_by_id;
    }

    public void setPlan_created_by_id(String plan_created_by_id) {
        this.plan_created_by_id = plan_created_by_id;
    }

    public String getPlan_approved_by_id() {
        return plan_approved_by_id;
    }

    public void setPlan_approved_by_id(String plan_approved_by_id) {
        this.plan_approved_by_id = plan_approved_by_id;
    }

    public String getPlan_created_by_name() {
        return plan_created_by_name;
    }

    public void setPlan_created_by_name(String plan_created_by_name) {
        this.plan_created_by_name = plan_created_by_name;
    }

    public String getPlan_approved_by_name() {
        return plan_approved_by_name;
    }

    public void setPlan_approved_by_name(String plan_approved_by_name) {
        this.plan_approved_by_name = plan_approved_by_name;
    }

    public String getPolice_post_name() {
        return police_post_name;
    }

    public void setPolice_post_name(String police_post_name) {
        this.police_post_name = police_post_name;
    }

    public String getPolice_post_number() {
        return police_post_number;
    }

    public void setPolice_post_number(String police_post_number) {
        this.police_post_number = police_post_number;
    }

    public String getPolice_officer_names() {
        return police_officer_names;
    }

    public void setPolice_officer_names(String police_officer_names) {
        this.police_officer_names = police_officer_names;
    }

    public String getPolice_officers_numbers() {
        return police_officers_numbers;
    }

    public void setPolice_officers_numbers(String police_officers_numbers) {
        this.police_officers_numbers = police_officers_numbers;
    }

    public String getNumber_of_police_officers() {
        return number_of_police_officers;
    }

    public void setNumber_of_police_officers(String number_of_police_officers) {
        this.number_of_police_officers = number_of_police_officers;
    }

    public String getIs_cross_border() {
        return is_cross_border;
    }

    public void setIs_cross_border(String is_cross_border) {
        this.is_cross_border = is_cross_border;
    }

    public String getPolice_officers_confirmation() {
        return police_officers_confirmation;
    }

    public void setPolice_officers_confirmation(String police_officers_confirmation) {
        this.police_officers_confirmation = police_officers_confirmation;
    }

    public String getSupport_staff_confirmation() {
        return support_staff_confirmation;
    }

    public void setSupport_staff_confirmation(String support_staff_confirmation) {
        this.support_staff_confirmation = support_staff_confirmation;
    }

    public String getBoxbag_confirmation() {
        return boxbag_confirmation;
    }

    public void setBoxbag_confirmation(String boxbag_confirmation) {
        this.boxbag_confirmation = boxbag_confirmation;
    }

    public String getSeals_confirmation() {
        return seals_confirmation;
    }

    public void setSeals_confirmation(String seals_confirmation) {
        this.seals_confirmation = seals_confirmation;
    }

    public String getEvents_reviewed() {
        return events_reviewed;
    }

    public void setEvents_reviewed(String events_reviewed) {
        this.events_reviewed = events_reviewed;
    }

    public String getDocuments_reviewed() {
        return documents_reviewed;
    }

    public void setDocuments_reviewed(String documents_reviewed) {
        this.documents_reviewed = documents_reviewed;
    }

    public String getDecrew_requested() {
        return decrew_requested;
    }

    public void setDecrew_requested(String decrew_requested) {
        this.decrew_requested = decrew_requested;
    }

    public String getDecrew_otp_confirmed() {
        return decrew_otp_confirmed;
    }

    public void setDecrew_otp_confirmed(String decrew_otp_confirmed) {
        this.decrew_otp_confirmed = decrew_otp_confirmed;
    }

    public String getDecrew_otp_id() {
        return decrew_otp_id;
    }

    public void setDecrew_otp_id(String decrew_otp_id) {
        this.decrew_otp_id = decrew_otp_id;
    }

    public String getAudit_trail_user_id() {
        return audit_trail_user_id;
    }

    public void setAudit_trail_user_id(String audit_trail_user_id) {
        this.audit_trail_user_id = audit_trail_user_id;
    }


    public String getLead_car_confirmation() {
        return lead_car_confirmation;
    }

    public void setLead_car_confirmation(String lead_car_confirmation) {
        this.lead_car_confirmation = lead_car_confirmation;
    }

    public String getChase_car_confirmation() {
        return chase_car_confirmation;
    }

    public void setChase_car_confirmation(String chase_car_confirmation) {
        this.chase_car_confirmation = chase_car_confirmation;
    }

    public String getLead_driver_confirmation() {
        return lead_driver_confirmation;
    }

    public void setLead_driver_confirmation(String lead_driver_confirmation) {
        this.lead_driver_confirmation = lead_driver_confirmation;
    }

    public String getChase_driver_confirmation() {
        return chase_driver_confirmation;
    }

    public void setChase_driver_confirmation(String chase_driver_confirmation) {
        this.chase_driver_confirmation = chase_driver_confirmation;
    }


}
