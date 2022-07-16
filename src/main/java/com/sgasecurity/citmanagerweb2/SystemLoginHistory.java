package com.sgasecurity.citmanagerweb2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class SystemLoginHistory {



    @javax.persistence.Id
    @Column(name="id")
    @GeneratedValue

    private Integer id;
    private String timestamp;
    private String update_timestamp;
    private String user_id;
    private String login_application_type;
    private String login_device_id;
    private String login_device_remote_address;

    private String login_device_user_agent;
    private String login_event;
    private String login_session_details;
    private String status;


    public SystemLoginHistory()
    {

    }

    public SystemLoginHistory(String timestamp, String update_timestamp, String user_id, String login_application_type, String login_device_id, String login_device_remote_address, String login_device_user_agent, String login_event, String login_session_details, String status) {
        this.timestamp = timestamp;
        this.update_timestamp = update_timestamp;
        this.user_id = user_id;
        this.login_application_type = login_application_type;
        this.login_device_id = login_device_id;
        this.login_device_remote_address = login_device_remote_address;
        this.login_device_user_agent = login_device_user_agent;
        this.login_event = login_event;
        this.login_session_details = login_session_details;
        this.status = status;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getLogin_application_type() {
        return login_application_type;
    }

    public void setLogin_application_type(String login_application_type) {
        this.login_application_type = login_application_type;
    }

    public String getLogin_device_id() {
        return login_device_id;
    }

    public void setLogin_device_id(String login_device_id) {
        this.login_device_id = login_device_id;
    }

    public String getLogin_device_remote_address() {
        return login_device_remote_address;
    }

    public void setLogin_device_remote_address(String login_device_remote_address) {
        this.login_device_remote_address = login_device_remote_address;
    }

    public String getLogin_device_user_agent() {
        return login_device_user_agent;
    }

    public void setLogin_device_user_agent(String login_device_user_agent) {
        this.login_device_user_agent = login_device_user_agent;
    }

    public String getLogin_event() {
        return login_event;
    }

    public void setLogin_event(String login_event) {
        this.login_event = login_event;
    }

    public String getLogin_session_details() {
        return login_session_details;
    }

    public void setLogin_session_details(String login_session_details) {
        this.login_session_details = login_session_details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
