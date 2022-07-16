package com.sgasecurity.citmanagerweb2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class SystemUsers {


    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue

    private Integer id;
    private String timestamp;
    private String update_timestamp;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String mobile;
    private String is_customer_representative;
    private String customer_id;
    private String customer_name;
    private String customer_branch_id;
    private String customer_branch_name;
    private String customer_representative_id;
    private String user_role;
    private String country_office_id;
    private String country_office_name;
    private String branch_id;
    private String branch_name;
    private String id_passport_no;
    private String passport_photo;


    public SystemUsers()
    {

    }

    public SystemUsers(String timestamp, String update_timestamp, String password, String firstname, String lastname, String email, String mobile, String is_customer_representative, String customer_id, String customer_name, String customer_branch_id, String customer_branch_name, String customer_representative_id, String user_role, String country_office_id, String country_office_name, String branch_id, String branch_name, String id_passport_no, String passport_photo, String rfid_nfc_tag, String assigned_imei, String assigned_sim_icc, String assigned_workstation_device, String log_in_type, String status, String comments, String audit_trail_user_id) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.is_customer_representative = is_customer_representative;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_branch_id = customer_branch_id;
        this.customer_branch_name = customer_branch_name;
        this.customer_representative_id = customer_representative_id;
        this.user_role = user_role;
        this.country_office_id = country_office_id;
        this.country_office_name = country_office_name;
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.id_passport_no = id_passport_no;
        this.passport_photo = passport_photo;
        this.rfid_nfc_tag = rfid_nfc_tag;
        this.assigned_imei = assigned_imei;
        this.assigned_sim_icc = assigned_sim_icc;
        this.assigned_workstation_device = assigned_workstation_device;
        this.log_in_type = log_in_type;
        this.status = status;
        this.comments = comments;
        this.audit_trail_user_id = audit_trail_user_id;
    }

    private String rfid_nfc_tag;
    private String assigned_imei;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIs_customer_representative() {
        return is_customer_representative;
    }

    public void setIs_customer_representative(String is_customer_representative) {
        this.is_customer_representative = is_customer_representative;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_branch_id() {
        return customer_branch_id;
    }

    public void setCustomer_branch_id(String customer_branch_id) {
        this.customer_branch_id = customer_branch_id;
    }

    public String getCustomer_branch_name() {
        return customer_branch_name;
    }

    public void setCustomer_branch_name(String customer_branch_name) {
        this.customer_branch_name = customer_branch_name;
    }

    public String getCustomer_representative_id() {
        return customer_representative_id;
    }

    public void setCustomer_representative_id(String customer_representative_id) {
        this.customer_representative_id = customer_representative_id;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getCountry_office_id() {
        return country_office_id;
    }

    public void setCountry_office_id(String country_office_id) {
        this.country_office_id = country_office_id;
    }

    public String getCountry_office_name() {
        return country_office_name;
    }

    public void setCountry_office_name(String country_office_name) {
        this.country_office_name = country_office_name;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getId_passport_no() {
        return id_passport_no;
    }

    public void setId_passport_no(String id_passport_no) {
        this.id_passport_no = id_passport_no;
    }

    public String getPassport_photo() {
        return passport_photo;
    }

    public void setPassport_photo(String passport_photo) {
        this.passport_photo = passport_photo;
    }

    public String getRfid_nfc_tag() {
        return rfid_nfc_tag;
    }

    public void setRfid_nfc_tag(String rfid_nfc_tag) {
        this.rfid_nfc_tag = rfid_nfc_tag;
    }

    public String getAssigned_imei() {
        return assigned_imei;
    }

    public void setAssigned_imei(String assigned_imei) {
        this.assigned_imei = assigned_imei;
    }

    public String getAssigned_sim_icc() {
        return assigned_sim_icc;
    }

    public void setAssigned_sim_icc(String assigned_sim_icc) {
        this.assigned_sim_icc = assigned_sim_icc;
    }

    public String getAssigned_workstation_device() {
        return assigned_workstation_device;
    }

    public void setAssigned_workstation_device(String assigned_workstation_device) {
        this.assigned_workstation_device = assigned_workstation_device;
    }

    public String getLog_in_type() {
        return log_in_type;
    }

    public void setLog_in_type(String log_in_type) {
        this.log_in_type = log_in_type;
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

    public String getAudit_trail_user_id() {
        return audit_trail_user_id;
    }

    public void setAudit_trail_user_id(String audit_trail_user_id) {
        this.audit_trail_user_id = audit_trail_user_id;
    }

    private String assigned_sim_icc;
    private String assigned_workstation_device;
    private String log_in_type;
    private String status;
    private String comments;
    private String audit_trail_user_id;



}
