package com.sgasecurity.citmanagerweb2.customermanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.sql.Timestamp;

@Entity
public class Customer {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue

    private Integer id;
    private Timestamp timestamp;
    private Timestamp updateTimestamp;
    private String customerName;
    private String manualCustomerReference;
    private Integer currentContractId;
    private String currentContractManualNumber;

    private String currentContractStatus;
    private String currentContractType;
    private String customerType;
    private String organisationType;
    private String hqPhysicalAddress;

    private String hqLatitude;
    private String hqLongitude;
    private String hqPostalAddress;
    private String hqEmail;
    private String hqTelephone;
    private Integer auditTrailUserId;

    public Customer() {

    }

    public Customer( String customerName, String manualCustomerReference, Integer currentContractId, String currentContractManualNumber, String currentContractStatus, String currentContractType, String customerType, String organisationType, String hqPhysicalAddress, String hqLatitude,String hqLongitude, String hqPostalAddress, String hqEmail, String hqTelephone, Integer auditTrailUserId) {
        this.customerName = customerName;
        this.manualCustomerReference = manualCustomerReference;
        this.currentContractId = currentContractId;
        this.currentContractManualNumber = currentContractManualNumber;
        this.currentContractStatus = currentContractStatus;
        this.currentContractType = currentContractType;
        this.customerType = customerType;
        this.organisationType = organisationType;
        this.hqPhysicalAddress = hqPhysicalAddress;
        this.hqLatitude = hqLatitude;
        this.hqLongitude = hqLongitude;
        this.hqPostalAddress = hqPostalAddress;
        this.hqEmail = hqEmail;
        this.hqTelephone = hqTelephone;
        this.auditTrailUserId = auditTrailUserId;
    }
    public Customer( String customerName,String customerType, String hqPhysicalAddress, String hqLatitude,String hqLongitude, String hqPostalAddress, String hqEmail, String hqTelephone, Integer auditTrailUserId) {
        this.customerName = customerName;
        this.customerType = customerType;
        this.hqPhysicalAddress = hqPhysicalAddress;
        this.hqLatitude = hqLatitude;
        this.hqLongitude = hqLongitude;
        this.hqPostalAddress = hqPostalAddress;
        this.hqEmail = hqEmail;
        this.hqTelephone = hqTelephone;
        this.auditTrailUserId = auditTrailUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getManualCustomerReference() {
        return manualCustomerReference;
    }

    public void setManualCustomerReference(String manualCustomerReference) {
        this.manualCustomerReference = manualCustomerReference;
    }

    public Integer getCurrentContractId() {
        return currentContractId;
    }

    public void setCurrentContractId(Integer currentContractId) {
        this.currentContractId = currentContractId;
    }

    public String getCurrentContractManualNumber() {
        return currentContractManualNumber;
    }

    public void setCurrentContractManualNumber(String currentContractManualNumber) {
        this.currentContractManualNumber = currentContractManualNumber;
    }

    public String getCurrentContractStatus() {
        return currentContractStatus;
    }

    public void setCurrentContractStatus(String currentContractStatus) {
        this.currentContractStatus = currentContractStatus;
    }

    public String getCurrentContractType() {
        return currentContractType;
    }

    public void setCurrentContractType(String currentContractType) {
        this.currentContractType = currentContractType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(String organisationType) {
        this.organisationType = organisationType;
    }

    public String getHqPhysicalAddress() {
        return hqPhysicalAddress;
    }

    public void setHqPhysicalAddress(String hqPhysicalAddress) {
        this.hqPhysicalAddress = hqPhysicalAddress;
    }

    public String getHqLatitude() {
        return hqLatitude;
    }

    public void setHqLatitude(String hqLatitude) {
        this.hqLatitude = hqLatitude;
    }
    public String getHqLongitude() {
        return hqLongitude;
    }

    public void setHqLongitude(String hqLongitude) {
        this.hqLongitude = hqLongitude;
    }


    public String getHqPostalAddress() {
        return hqPostalAddress;
    }

    public void setHqPostalAddress(String hqPostalAddress) {
        this.hqPostalAddress = hqPostalAddress;
    }

    public String getHqEmail() {
        return hqEmail;
    }

    public void setHqEmail(String hqEmail) {
        this.hqEmail = hqEmail;
    }

    public String getHqTelephone() {
        return hqTelephone;
    }

    public void setHqTelephone(String hqTelephone) {
        this.hqTelephone = hqTelephone;
    }

    public Integer getAuditTrailUserId() {
        return auditTrailUserId;
    }

    public void setAuditTrailUserId(Integer auditTrailUserId) {
        this.auditTrailUserId = auditTrailUserId;
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
}
