package com.lanou.hrd.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dllo on 17/10/24.
 */
@Component
public class Crm_staff {

    private String staffId;
    private String loginName;
    private String loginPwd;
    private String staffName;
    private String gender;
    private Date onDutyDate;
    private Crm_post crm_post;

    public Crm_staff(String loginName, String loginPwd, String staffName, String gender, Date onDutyDate) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
    }

    public Crm_staff(String loginName, String loginPwd, String staffName, String gender, Date onDutyDate, Crm_post crm_post) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
        this.crm_post = crm_post;
    }

    public Crm_staff(String staffId, String loginName, String loginPwd, String staffName, String gender, Date onDutyDate, Crm_post crm_post) {
        this.staffId = staffId;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.staffName = staffName;
        this.gender = gender;
        this.onDutyDate = onDutyDate;
        this.crm_post = crm_post;
    }

    public Crm_staff() {
    }


    @Override
    public String toString() {
        return "Crm_staff{" +
                "staffId='" + staffId + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", staffName='" + staffName + '\'' +
                ", gender='" + gender + '\'' +
                ", onDutyDate=" + onDutyDate +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getOnDutyDate() {
        return onDutyDate;
    }

    public void setOnDutyDate(Date onDutyDate) {
        this.onDutyDate = onDutyDate;
    }

    public Crm_post getCrm_post() {
        return crm_post;
    }

    public void setCrm_post(Crm_post crm_post) {
        this.crm_post = crm_post;
    }
}
