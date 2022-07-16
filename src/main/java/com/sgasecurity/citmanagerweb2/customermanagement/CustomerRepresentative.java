package com.sgasecurity.citmanagerweb2.customermanagement;


import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.sql.Timestamp;

@Entity
public class CustomerRepresentative {
    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private Timestamp timestamp;
    private Timestamp updateTimestamp;
    private Integer customerId;
    private String customerRepresentativeName;
    private String position;
    private String mobileNumber;
    private String email;
    private String nationalIdPassport;
    private String passportPhoto;
    private String supportingDocuments1;
    private String supportingDocuments2;
    private String supportingDocuments3;
    private String comments;
    private String status;
    private String isBranch;
    private Integer branchId;
    private Integer auditTrailUserId;

    public CustomerRepresentative() {
    }

    public CustomerRepresentative( String customerRepresentativeName, String position, String mobileNumber, String email,String nationalIdPassport, String passportPhoto, String supportingDocuments1, String supportingDocuments2, String supportingDocuments3, String comments, String status, String isBranch, Integer branchId, Integer auditTrailUserId) {
        this.customerRepresentativeName = customerRepresentativeName;
        this.position = position;
        this.mobileNumber = mobileNumber;
        this.email=email;
        this.nationalIdPassport = nationalIdPassport;
        this.passportPhoto = passportPhoto;
        this.supportingDocuments1 = supportingDocuments1;
        this.supportingDocuments2 = supportingDocuments2;
        this.supportingDocuments3 = supportingDocuments3;
        this.comments = comments;
        this.status = status;
        this.isBranch = isBranch;
        this.branchId = branchId;
        this.auditTrailUserId = auditTrailUserId;
    }

    public CustomerRepresentative( String customerRepresentativeName, String position, String mobileNumber, String email,String nationalIdPassport, String passportPhoto, String supportingDocuments1, Integer auditTrailUserId) {

        this.customerRepresentativeName = customerRepresentativeName;
        this.position = position;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.nationalIdPassport = nationalIdPassport;
        this.passportPhoto = passportPhoto;
        this.supportingDocuments1 = supportingDocuments1;
        this.auditTrailUserId = auditTrailUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerRepresentativeName() {
        return customerRepresentativeName;
    }

    public void setCustomerRepresentativeName(String customerRepresentativeName) {
        this.customerRepresentativeName = customerRepresentativeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalIdPassport() {
        return nationalIdPassport;
    }

    public void setNationalIdPassport(String nationalIdPassport) {
        this.nationalIdPassport = nationalIdPassport;
    }

    public String getPassportPhoto() {
        return passportPhoto;
    }

    public void setPassportPhoto(String passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    public String getSupportingDocuments1() {
        return supportingDocuments1;
    }

    public void setSupportingDocuments1(String supportingDocuments1) {
        this.supportingDocuments1 = supportingDocuments1;
    }

    public String getSupportingDocuments2() {
        return supportingDocuments2;
    }

    public void setSupportingDocuments2(String supportingDocuments2) {
        this.supportingDocuments2 = supportingDocuments2;
    }

    public String getSupportingDocuments3() {
        return supportingDocuments3;
    }

    public void setSupportingDocuments3(String supportingDocuments3) {
        this.supportingDocuments3 = supportingDocuments3;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsBranch() {
        return isBranch;
    }

    public void setIsBranch(String isBranch) {
        this.isBranch = isBranch;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getAuditTrailUserId() {
        return auditTrailUserId;
    }

    public void setAuditTrailUserId(Integer auditTrailUserId) {
        this.auditTrailUserId = auditTrailUserId;
    }
}
