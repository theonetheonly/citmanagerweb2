package com.sgasecurity.citmanagerweb2.customermanagement;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class CustomerRequest {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;
    private Timestamp timestamp;
    private Timestamp updateTimestamp;
    private Integer customerId;
    private String customerName;
    private Integer contractId;
    private String contractManualNumber;
    private String customerRequestType;
    private String serviceName;
    private String sourceName;
    private String sourceCoordinates;
    private String destinationName;
    private String destinationCoordinates;
    private Integer distanceEstimate;
    private String billingType;
    private Date dateRequired;
    private String timeRequired;
    private Integer durationHours;
    private Integer customerRepresentativeId;
    private String customerRepresentativeName;
    private String requestNotes;
    private String status;
    private Integer planningId;
    private Integer auditTrailUserId;

    private String customerBranchId;
    private String customerBranchName;

    public CustomerRequest() {
    }

    private String sourceClientBranchId;

    private String sourceClientId;

    private String destinationClientBranchId;
    private String destinationClientId;

    public String getCustomerBranchId() {
        return customerBranchId;
    }

    public void setCustomerBranchId(String customerBranchId) {
        this.customerBranchId = customerBranchId;
    }

    public String getCustomerBranchName() {
        return customerBranchName;
    }

    public void setCustomerBranchName(String customerBranchName) {
        this.customerBranchName = customerBranchName;
    }

    public String getSourceClientBranchId() {
        return sourceClientBranchId;
    }

    public void setSourceClientBranchId(String sourceClientBranchId) {
        this.sourceClientBranchId = sourceClientBranchId;
    }

    public String getSourceClientId() {
        return sourceClientId;
    }

    public void setSourceClientId(String sourceClientId) {
        this.sourceClientId = sourceClientId;
    }

    public String getDestinationClientBranchId() {
        return destinationClientBranchId;
    }

    public void setDestinationClientBranchId(String destinationClientBranchId) {
        this.destinationClientBranchId = destinationClientBranchId;
    }

    public String getDestinationClientId() {
        return destinationClientId;
    }

    public void setDestinationClientId(String destinationClientId) {
        this.destinationClientId = destinationClientId;
    }

    public CustomerRequest(Integer customerId, String customerName, Integer contractId, String contractManualNumber, String customerRequestType, String serviceName, String sourceName, String sourceCoordinates, String destinationName, String destinationCoordinates, Integer distanceEstimate, String billingType, Date dateRequired, String timeRequired, Integer durationHours, Integer customerRepresentativeId, String customerRepresentativeName, String requestNotes, String status, Integer planningId, Integer auditTrailUserId, String customerBranchId, String customerBranchName, String sourceClientBranchId, String sourceClientId, String destinationClientBranchId, String destinationClientId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contractId = contractId;
        this.contractManualNumber = contractManualNumber;
        this.customerRequestType = customerRequestType;
        this.serviceName = serviceName;
        this.sourceName = sourceName;
        this.sourceCoordinates = sourceCoordinates;
        this.destinationName = destinationName;
        this.destinationCoordinates = destinationCoordinates;
        this.distanceEstimate = distanceEstimate;
        this.billingType = billingType;
        this.dateRequired = dateRequired;
        this.timeRequired = timeRequired;
        this.durationHours = durationHours;
        this.customerRepresentativeId = customerRepresentativeId;
        this.customerRepresentativeName = customerRepresentativeName;
        this.requestNotes = requestNotes;
        this.status = status;
        this.planningId = planningId;
        this.auditTrailUserId = auditTrailUserId;
        this.customerBranchId = customerBranchId;
        this.customerBranchName = customerBranchName;
        this.sourceClientBranchId = sourceClientBranchId;
        this.sourceClientId = sourceClientId;
        this.destinationClientBranchId = destinationClientBranchId;
        this.destinationClientId = destinationClientId;

    }

    public CustomerRequest(String customerName, String contractManualNumber, String customerRequestType,
                           String serviceName, String sourceName, String sourceCoordinates,
                           String destinationName, String destinationCoordinates, Integer distanceEstimate,
                           Date dateRequired, String timeRequired, Integer durationHours,
                           String customerRepresentativeName,
                           String requestNotes, String status, Integer auditTrailUserId) {
        this.customerName = customerName;
        this.contractManualNumber = contractManualNumber;
        this.customerRequestType = customerRequestType;
        this.serviceName = serviceName;
        this.sourceName = sourceName;
        this.sourceCoordinates = sourceCoordinates;
        this.destinationName = destinationName;
        this.destinationCoordinates = destinationCoordinates;
        this.distanceEstimate = distanceEstimate;
        this.dateRequired = dateRequired;
        this.timeRequired = timeRequired;
        this.durationHours = durationHours;
        this.customerRepresentativeName = customerRepresentativeName;
        this.requestNotes = requestNotes;
        this.status = status;
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


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractManualNumber() {
        return contractManualNumber;
    }

    public void setContractManualNumber(String contractManualNumber) {
        this.contractManualNumber = contractManualNumber;
    }

    public String getCustomerRequestType() {
        return customerRequestType;
    }

    public void setCustomerRequestType(String customerRequestType) {
        this.customerRequestType = customerRequestType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceCoordinates() {
        return sourceCoordinates;
    }

    public void setSourceCoordinates(String sourceCoordinates) {
        this.sourceCoordinates = sourceCoordinates;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public void setDestinationCoordinates(String destinationCoordinates) {
        this.destinationCoordinates = destinationCoordinates;
    }

    public Integer getDistanceEstimate() {
        return distanceEstimate;
    }

    public void setDistanceEstimate(Integer distanceEstimate) {
        this.distanceEstimate = distanceEstimate;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public Date getDateRequired() {
        return dateRequired;
    }

    public void setDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
    }

    public String getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(String timeRequired) {
        this.timeRequired = timeRequired;
    }

    public Integer getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(Integer durationHours) {
        this.durationHours = durationHours;
    }

    public Integer getCustomerRepresentativeId() {
        return customerRepresentativeId;
    }

    public void setCustomerRepresentativeId(Integer customerRepresentativeId) {
        this.customerRepresentativeId = customerRepresentativeId;
    }

    public String getCustomerRepresentativeName() {
        return customerRepresentativeName;
    }

    public void setCustomerRepresentativeName(String customerRepresentativeName) {
        this.customerRepresentativeName = customerRepresentativeName;
    }

    public String getRequestNotes() {
        return requestNotes;
    }

    public void setRequestNotes(String requestNotes) {
        this.requestNotes = requestNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPlanningId() {
        return planningId;
    }

    public void setPlanningId(Integer planningId) {
        this.planningId = planningId;
    }

    public Integer getAuditTrailUserId() {
        return auditTrailUserId;
    }

    public void setAuditTrailUserId(Integer auditTrailUserId) {
        this.auditTrailUserId = auditTrailUserId;
    }
}

