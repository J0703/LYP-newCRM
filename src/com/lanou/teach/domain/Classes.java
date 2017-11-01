package com.lanou.teach.domain;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by dllo on 17/10/28.
 */
@Component
public class Classes {

    private String classID;
//    private String lessonTypeID;
    private String name;
    private Date beginTime;
    private Date endTime;
    private String status;
    private int totalCount;
    private int upgradeCount;
    private int changeCount;
    private int runoffCount;
    private String remark;
    private String uploadPath;
    private String uploadFileName;
    private Date uploadTime;

    private Course_type lessonTypeID;

    public void setLessonTypeID(Course_type lessonTypeID) {
        this.lessonTypeID = lessonTypeID;
    }


    public Classes(String name, Date beginTime, Date endTime, String remark, Course_type lessonTypeID) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.remark = remark;
        this.lessonTypeID = lessonTypeID;
    }

    public Classes(String name, Date beginTime, Date endTime, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, Date uploadTime) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
    }



    public Course_type getLessonTypeID() {
        return lessonTypeID;
    }

    public Classes() {
    }

    public Classes(String name, Date beginTime, Date endTime, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, Date uploadTime, Course_type lessonTypeID) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
        this.lessonTypeID = lessonTypeID;
    }

    public Classes(String name, Date beginTime, Date endTime, String status, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, Date uploadTime, Course_type lessonTypeID) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
        this.lessonTypeID = lessonTypeID;
    }

    public Classes(String classID, String name, Date beginTime, Date endTime, String status, int totalCount, int upgradeCount, int changeCount, int runoffCount, String remark, String uploadPath, String uploadFileName, Date uploadTime, Course_type lessonTypeID) {
        this.classID = classID;
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.status = status;
        this.totalCount = totalCount;
        this.upgradeCount = upgradeCount;
        this.changeCount = changeCount;
        this.runoffCount = runoffCount;
        this.remark = remark;
        this.uploadPath = uploadPath;
        this.uploadFileName = uploadFileName;
        this.uploadTime = uploadTime;
        this.lessonTypeID = lessonTypeID;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "name='" + name + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", totalCount=" + totalCount +
                ", upgradeCount=" + upgradeCount +
                ", changeCount=" + changeCount +
                ", runoffCount=" + runoffCount +
                ", remark='" + remark + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", uploadFileName='" + uploadFileName + '\'' +
                ", uploadTime=" + uploadTime +
                ", lessonTypeID=" + lessonTypeID +
                '}';
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public int getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(int changeCount) {
        this.changeCount = changeCount;
    }

    public int getRunoffCount() {
        return runoffCount;
    }

    public void setRunoffCount(int runoffCount) {
        this.runoffCount = runoffCount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
