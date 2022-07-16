package com.sgasecurity.citmanagerweb2;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class SystemOtp {

    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    private  String timestamp;



    public String getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(String updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    private  String updateTimestamp;

    private String otpCode;
    private String otpCodeReply;
    private String sendMode;
    private String sendToMobile;
    private String sendToEmail;
    private String Context;
    private String Status;

    private Integer receiverUserId;

    public SystemOtp() {
    }

    public SystemOtp(String otpCode, String otpCodeReply, String sendMode, String sendToMobile, String sendToEmail, String context, String status, Integer receiverUserId) {
        //this.timestamp =timestamp;
        //this.updateTimestamp = updateTimestamp;
        this.otpCode = otpCode;
        this.otpCodeReply = otpCodeReply;
        this.sendMode = sendMode;
        this.sendToMobile = sendToMobile;
        this.sendToEmail = sendToEmail;
        Context = context;
        Status = status;
        this.receiverUserId = receiverUserId;
    }

    public Integer getId() {
        return id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public String getOtpCodeReply() {
        return otpCodeReply;
    }

    public void setOtpCodeReply(String otpCodeReply) {
        this.otpCodeReply = otpCodeReply;
    }

    public String getSendMode() {
        return sendMode;
    }

    public void setSendMode(String sendMode) {
        this.sendMode = sendMode;
    }

    public String getSendToMobile() {
        return sendToMobile;
    }

    public void setSendToMobile(String sendToMobile) {
        this.sendToMobile = sendToMobile;
    }

    public String getSendToEmail() {
        return sendToEmail;
    }

    public void setSendToEmail(String sendToEmail) {
        this.sendToEmail = sendToEmail;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getReceiverUserId() {
        return receiverUserId;
    }

    public void setReceiverUserId(Integer receiverUserId) {
        this.receiverUserId = receiverUserId;
    }
}
