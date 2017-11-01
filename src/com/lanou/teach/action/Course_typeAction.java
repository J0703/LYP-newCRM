package com.lanou.teach.action;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.domain.Course_type;
import com.lanou.teach.service.Course_typeService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by dllo on 17/10/31.
 */
@Controller("course_typeAction")
@Scope("prototype")
public class Course_typeAction extends ActionSupport {

    private String courseCost;
    private String total;
    private String courseName;
    private String remark;

    private double cost;
    private int tot;

    private Course_type course_type;

    private String ctid;


    /**
     * 更改一个课程
     */

    @Resource
    private Course_typeService course_typeService;

    /**
     * 添加一个课程
     */
    public String addCourse_type() {


//        System.out.println(course_type.getCourseTypeID());
        System.out.println(ctid);

//        System.out.println(!ctid.equals("null"));


        if (!StringUtils.isBlank(ctid)) {

            Course_type id = course_typeService.findId(ctid);

            id.setCourseName(courseName);
            id.setTotal(tot);
            id.setCourseCost(cost);
            id.setRemark(remark);

            course_typeService.upCourse(id);

        } else {

            Course_type courseType = new Course_type(cost, tot, courseName, remark);

            course_typeService.add(courseType);
//
        }


//        cost = Double.parseDouble(courseCost);
//
//        tot = Integer.parseInt(total);


        return SUCCESS;
    }

    /**
     * 添加课程的判断
     */
    public void validateAddCourse_type() {

        updateAndAdd();

    }



    public String updateCourse_type() {

        Course_type id = course_typeService.findId(ctid);

        id.setCourseName(courseName);
        id.setTotal(tot);
        id.setCourseCost(Double.parseDouble(courseCost));
        id.setRemark(remark);

        course_typeService.upCourse(id);

        return SUCCESS;
    }

    /**
     * 更改课程的判断
     */
    public void validateUpdateCourse_type() {

        updateAndAdd();

    }


    /**
     * 更改和添加的判断方法
     */
    private void updateAndAdd() {

//        String d = "\\d*\\.\\d*";
//        String i = "\\d*";

//        if (!Pattern.matches(d, courseCost) || !Pattern.matches(i, total)){
//
//            addActionError("请你不要故意捣乱好么?");

//        }else {

//        System.out.println(courName);
//        System.out.println(cost);
//        System.out.println(tot);

        if (StringUtils.isBlank(courseName)) addActionError("难道这个课程没有名字么?");

        if (cost == 0.0) addActionError("难道这个课不收钱?");

        if (tot == 0) addActionError("原来这个课是交钱不用上的");

//        }

    }


    /**
     * 用 id查询 员工信息
     */
    public String IdCourse() {

//        System.out.println(ctid);

        course_type = course_typeService.findId(ctid);

        return SUCCESS;
    }


    private String courName;
    private String mark;
    private int totalStart;
    private int totalEnd;
    private double lessonCostStart;
    private double lessonCostEnd;

    private PageBean<Course_type> pd;

    /**
     * 高级查询
     */
    public String findCourse_Type() {

        //        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;

//        int tStart = Integer.parseInt(totalStart);
//        int tEnd = Integer.parseInt(totalEnd);
//        int lStart = Integer.parseInt(lessonCostStart);
//        int lEnd = Integer.parseInt(lessonCostEnd);

        pd = course_typeService.findType(pc, ps, courName, mark, totalStart, totalEnd, lessonCostStart, lessonCostEnd);

//        List<Course_type> beanList = pd.getBeanList();
//
//        for (Course_type courseType : beanList) {
//            System.out.println(courseType.getCourseName());
//        }


        return SUCCESS;
    }

//    public void validateFindCourse_Type(){
//
//        String d = "\\d*\\.\\d*";
//        String i = "\\d*";
//
//        if ((!(totalStart == null) || !Pattern.matches(i, totalStart)) ||
//                (!(totalEnd == null) || !Pattern.matches(i, totalEnd)) ||
//                (!(lessonCostStart == null) || !Pattern.matches(d, lessonCostStart)) ||
//                (!(lessonCostEnd == null) || !Pattern.matches(d, lessonCostEnd))){
//
//            addActionError("请你不要故意捣乱好么?");
//
//        }
//
//    }


    //    pc : 页数
    private String pc;

    private int getPc() {
        /*
            1. 得到 pageCode
				> 如果 pc 参数不存在, pc = 1
				> 如果 pc 参数存在, 转成 int 类型
		 */

        String value = pc;
        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }

    private List<Course_type> cou;

    /**
     * 查询所有课程
     */
    public String findCourse() {

        cou = course_typeService.findAll();

//        for (Crm_department department : departments) {
//            System.out.println(department);
//        }


        return SUCCESS;
    }




    public String getCourseCost() {
        return courseCost;
    }

    public void setCourseCost(String courseCost) {
        this.courseCost = courseCost;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(int totalStart) {
        this.totalStart = totalStart;
    }

    public int getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(int totalEnd) {
        this.totalEnd = totalEnd;
    }

    public double getLessonCostStart() {
        return lessonCostStart;
    }

    public void setLessonCostStart(double lessonCostStart) {
        this.lessonCostStart = lessonCostStart;
    }

    public double getLessonCostEnd() {
        return lessonCostEnd;
    }

    public void setLessonCostEnd(double lessonCostEnd) {
        this.lessonCostEnd = lessonCostEnd;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public PageBean<Course_type> getPd() {
        return pd;
    }

    public void setPd(PageBean<Course_type> pd) {
        this.pd = pd;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public String getCtid() {
        return ctid;
    }

    public void setCtid(String ctid) {
        this.ctid = ctid;
    }

    public Course_type getCourse_type() {
        return course_type;
    }

    public void setCourse_type(Course_type course_type) {
        this.course_type = course_type;
    }

    public List<Course_type> getCou() {
        return cou;
    }

    public void setCou(List<Course_type> cou) {
        this.cou = cou;
    }
}
