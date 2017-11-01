package com.lanou.consulting.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dllo on 17/10/28.
 */
@Component
public class Refer {

    private String referId;
    private String name;
    private String telephone;
    private String qq;
    private Date createDate;
    private String intentionLevel;
    private String courseTypeId;
    private String classId;
    private String source;
    private String status;
    private String remark;
    private String staffId;

    private Refer refer;

    public Refer getRefer() {
        return refer;
    }

    public void setRefer(Refer refer) {
        this.refer = refer;
    }

    public Refer() {
    }

    public Refer(String referId, String name, String telephone, String qq, Date createDate, String intentionLevel, String courseTypeId, String classId, String source, String status, String remark, String staffId) {
        this.referId = referId;
        this.name = name;
        this.telephone = telephone;
        this.qq = qq;
        this.createDate = createDate;
        this.intentionLevel = intentionLevel;
        this.courseTypeId = courseTypeId;
        this.classId = classId;
        this.source = source;
        this.status = status;
        this.remark = remark;
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Refer{" +
                "referId='" + referId + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", createDate=" + createDate +
                ", intentionLevel='" + intentionLevel + '\'' +
                ", courseTypeId='" + courseTypeId + '\'' +
                ", classId='" + classId + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", staffId='" + staffId + '\'' +
                '}';
    }

    public String getReferId() {
        return referId;
    }

    public void setReferId(String referId) {
        this.referId = referId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIntentionLevel() {
        return intentionLevel;
    }

    public void setIntentionLevel(String intentionLevel) {
        this.intentionLevel = intentionLevel;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
