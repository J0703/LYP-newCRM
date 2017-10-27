package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import com.lanou.hrd.service.PostService;
import com.lanou.hrd.service.StaffService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by dllo on 17/10/24.
 */
@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends ActionSupport {

    @Resource
    private StaffService staffService;

    //    登录名
    private String loginName;
    //    登录密码
    private String loginPwd;
    //    姓名
    private String staffName;
    //    性别
    private String gender;
    //    入职时间
    private Date onDutyDate;
    //    所属部门ID
    private String department;
    //    所属职务ID
    private String post;


    public String login() {
        if (staffService.login(loginName, loginPwd)) {
            return SUCCESS;
        } else {
            addActionError("用户名或密码错误");
            return ERROR;
        }
    }

    public void validateLogin() {
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(loginPwd)) {

            System.out.println(loginName);
            System.out.println(loginPwd);

            addActionError("用户名或密码不能为空, 请重新登录");
        }
    }


    @Resource
    private DepartmentService departmentService;

    @Resource
    private PostService postService;

    /**
     * 添加学生
     */
    public String addStaff() {

//        Crm_department Crm_department = departmentService.findID(department);

        Crm_post crm_post = postService.findID(post);

        Crm_staff crm_staff = new Crm_staff(loginName, loginPwd, staffName, gender, onDutyDate, crm_post);

        staffService.add(crm_staff);

        return SUCCESS;
    }

    private Set<Crm_staff> staffs;

    private PageBean<Crm_staff> pd;

    //    分页查询全部
    public String findAll() {


//        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;

//        StringBuffer sb = new StringBuffer();
//
//        sb.append("from Crm_staff where 1=1");

//        **********************
//        if (!Objects.equals(staffName, "")) {
//            String hql = "from Crm_staff where and staffName=?";
//            Object[] params = {staffName};
////            staffService.findAll();
//        } else if (!Objects.equals(post, "")) {
//
////        如果选择了部门, 则遍历部门方法
//        } else if (!Objects.equals(department, "-1")) {
//
////            获取部门的id, 并查询出该部门
//            Crm_department id = departmentService.findID(department);
//
////            建立posts的数组, 储存职务
//            Set<Crm_post> posts = id.getPosts();
//
////            遍历全部的职务, 并准备下一次遍历
//            for (Crm_post c : posts) {
//
////                建立 员工 数组, 存储员工
//                Set<Crm_staff> s = c.getStaffs();
//
////                遍历全部的员工并存储
//                for (Crm_staff staff : s) {
//
//                    staffs.add(staff);
//
//                }
//            }
//        }else {
////            staffs = staffService
//        }
//        *******************

//        System.out.println(department);
//
//        System.out.println(post);

//        System.out.println(!Objects.equals(department, "-1"));
//        System.out.println(!Objects.equals(post, "-1"));

        System.out.println(!Objects.equals(post, "-1"));



//        if (!Objects.equals(post, "-1")) {
//        String hql = "from Crm_staff where 1=1 Crm_staff.crm_post.postId";
//        Map<String, Object> params = new HashMap<>();
//        params.put("Crm_staff.crm_post.postId", post);
//        Object[] values = {post};
//        PageBean<Crm_staff> staff = staffService.findStaff(pc, ps, hql, params, values);
//        }


//        staffService.findAll()

//        staff.getBeanList();




//        传递 pc, ps 获得 pageBean
        pd = staffService.findAll(pc, ps);

//        pd.getBeanList().size();

//        List<Crm_staff> beanList = pd.getBeanList();
//
//        for (Crm_staff c : beanList) {
//            System.out.println(c.getCrm_post());
//            c.getCrm_post().getPostName();
//            c.getCrm_post().getCrm_department();
//        }


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
        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }

    public PageBean<Crm_staff> getPd() {
        return pd;
    }

    public void setPd(PageBean<Crm_staff> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
