package com.lanou.consulting.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dllo on 17/10/28.
 */
@Component
public class Follow {

    private String followId;
    private Date followTime;
    private String content;
    private String staffID;
    private String referID;

    @Override
    public String toString() {
        return "Follow{" +
                "followId='" + followId + '\'' +
                ", followTime=" + followTime +
                ", content='" + content + '\'' +
                ", staffID='" + staffID + '\'' +
                ", referID='" + referID + '\'' +
                '}';
    }

    public Follow(String followId, Date followTime, String content, String staffID) {
        this.followId = followId;
        this.followTime = followTime;
        this.content = content;
        this.staffID = staffID;
    }

    public Follow(String followId, Date followTime, String content) {
        this.followId = followId;
        this.followTime = followTime;
        this.content = content;
    }

    public Follow(String followId, Date followTime, String content, String staffID, String referID) {
        this.followId = followId;
        this.followTime = followTime;
        this.content = content;
        this.staffID = staffID;
        this.referID = referID;
    }

    public Follow() {
    }

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getReferID() {
        return referID;
    }

    public void setReferID(String referID) {
        this.referID = referID;
    }
}
