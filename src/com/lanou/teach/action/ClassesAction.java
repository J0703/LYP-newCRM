package com.lanou.teach.action;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.domain.Classes;
import com.lanou.teach.domain.Course_type;
import com.lanou.teach.service.ClassesService;
import com.lanou.teach.service.Course_typeService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by dllo on 17/10/28.
 */
@Controller("classesAction")
@Scope("prototype")
public class ClassesAction extends ActionSupport {

    @Resource
    private ClassesService classesService;

    @Resource
    private Course_typeService course_typeService;

    private String name;
    private Date beginTime;
    private Date endTime;
    private String remark;
    private String courseTypeId;


    private PageBean<Classes> pd;

    public String classesPaging(){

        //        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;
//        传递 pc, ps 获得 pageBean
        pd = classesService.findPaging(pc, ps);


        return SUCCESS;
    }

    //    pc : 页数
    private String pc;

    private int getPc() {
        /*
            1. 得到 pageCode
				> 如果 pc 参数不存在, pc = 1
				> 如果 pc 参数存在, 转成 int 类型
		 */

        String value = pc;

        System.out.println(value);

        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }


    public String addClasses(){

        Course_type course = course_typeService.findId(courseTypeId);

        Classes classes = new Classes(name, beginTime, endTime, remark, course);


        classesService.add(classes);

//        classesService.add();

        return SUCCESS;
    }

    public PageBean<Classes> getPd() {
        return pd;
    }

    public void setPd(PageBean<Classes> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }
}
