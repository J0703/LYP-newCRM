package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import com.lanou.hrd.service.PostService;
import com.lanou.hrd.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
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

    private String depID;
    private String pid;
    private String sna;
    private String staffId;

    public String login() {

        Crm_staff staffOnePiece = staffService.login(loginName, loginPwd);

        if (staffOnePiece != null) {

            ServletContext servletContext = ServletActionContext.getServletContext();
            servletContext.setAttribute("staffOnePiece", staffOnePiece);

            return SUCCESS;
        } else {
            addActionError("用户名或密码错误");
            return ERROR;
        }
    }

    public void validateLogin() {
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(loginPwd)) {

//            System.out.println(loginName);
//            System.out.println(loginPwd);

            addActionError("用户名或密码不能为空, 请重新登录");
        }
    }


    private String oldPassword;
    private String newPassword;
    private String reNewPassword;

    /**
     * 更改密码方法
     * 就是获取id 更改密码
     */
    public String changePassword(){

        ServletContext servletContext = ServletActionContext.getServletContext();

        Crm_staff staffOnePiece = (Crm_staff) servletContext.getAttribute("staffOnePiece");

        staffOnePiece.setLoginPwd(newPassword);

        staffService.staffUpdate(staffOnePiece);

//        servletContext.removeAttribute("staffOnePiece");

        return SUCCESS;
    }

    /**
     * 清除登录状态
     */
    public String removeStaff(){

        ServletContext servletContext = ServletActionContext.getServletContext();

        servletContext.removeAttribute("staffOnePiece");

        return SUCCESS;
    }



    /* 更改密码拦截验证 */
    public void validateChangePassword(){

        ServletContext servletContext = ServletActionContext.getServletContext();

        Crm_staff staffOnePiece = (Crm_staff) servletContext.getAttribute("staffOnePiece");

        if(!staffOnePiece.getLoginPwd().equals(oldPassword)){

            addActionError("欧尼酱, 你的初始密码好像不太对哦 （￣へ￣）");

        } else if(StringUtils.isBlank(newPassword) || StringUtils.isBlank(reNewPassword)){

            addActionError("你是在暗示自己是baka么, 只有空密码才能记住");

        } else if(!newPassword.equals(reNewPassword)){

            addActionError("欧尼酱, 新密码要两次都相同哦 (/≧▽≦/)");

        } else if(oldPassword.equals(newPassword)){

            addActionError("这和原来的密码有什么区别么（╯‵□′）╯︵┴─┴");

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

//        Crm_department crmDepartment = departmentService.findID(department);

        Crm_post crmPost = postService.findID(pid);

//        crmPost.setCrm_department(crmDepartment);

//        if (!StringUtils.isEmpty(staffId)) {

//            System.out.println(loginName);

//            Crm_staff st = staffService.findId(staffId);
//            st.setLoginName(loginName);
//            st.setLoginPwd(loginPwd);
//            st.setStaffName(sna);
//            st.setGender(gender);
//            st.setOnDutyDate(onDutyDate);
//            st.setCrm_post(crmPost);
//
//            staffService.staffUpdate(st);

//        } else {

            Crm_staff crm_staff = new Crm_staff(loginName, loginPwd, sna, gender, onDutyDate, crmPost);

            staffService.add(crm_staff);

//        }

        return SUCCESS;
    }

    /* 表单判空方法 */
    public void validateAddStaff() {

//        System.out.println(onDutyDate);

//        System.out.println(staff.getLoginName());

//        if ((pid == null) && post.equals("-1")) addActionError("难道这个员工不属于这个单位?");
//
//        if (StringUtils.isBlank(loginName)) addActionError("你拿什么登录啊?亲!");
//
//        if (StringUtils.isBlank(loginPwd)) addActionError("密码怎么不见了?");
//
//        if (StringUtils.isBlank(sna)) addActionError("可能这个人是个没名字的黑户");
//
//        if (onDutyDate == null) addActionError("难到这个人的入职时间超过了N个世纪");

        updateAndAdd();


    }


    /**
     * 更改员工
     */
    public String updateStaff() {

        Crm_post crmPost = postService.findID(pid);

        Crm_staff st = staffService.findId(staffId);
        st.setLoginName(loginName);
        st.setLoginPwd(loginPwd);
        st.setStaffName(sna);
        st.setGender(gender);
        st.setOnDutyDate(onDutyDate);
        st.setCrm_post(crmPost);

        staffService.staffUpdate(st);

        return SUCCESS;
    }

    /* 表单判空方法 */
    public void validateUpdateStaff() {

//        System.out.println(onDutyDate);

//        System.out.println(staff.getLoginName());

//        if ((pid == null) && post.equals("-1")) addActionError("难道这个员工不属于这个单位?");
//
//        if (StringUtils.isBlank(loginName)) addActionError("你拿什么登录啊?亲!");
//
//        if (StringUtils.isBlank(loginPwd)) addActionError("密码怎么不见了?");
//
//        if (StringUtils.isBlank(sna)) addActionError("可能这个人是个没名字的黑户");
//
//        if (onDutyDate == null) addActionError("难到这个人的入职时间超过了N个世纪");

        staff = staffService.findId(staffId);

        updateAndAdd();


    }


    private void updateAndAdd(){

        if ((pid == null) && post.equals("-1")) addActionError("难道这个员工不属于这个单位?");

        if (StringUtils.isBlank(loginName)) addActionError("你拿什么登录啊?亲!");

        if (StringUtils.isBlank(loginPwd)) addActionError("密码怎么不见了?");

        if (StringUtils.isBlank(sna)) addActionError("可能这个人是个没名字的黑户");

        if (onDutyDate == null) addActionError("难到这个人的入职时间超过了N个世纪");

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

//        System.out.println(Objects.equals(post, "-1"));
//        System.out.println(Objects.equals(post, ""));
//        System.out.println(post == null);
//        System.out.println(post.isEmpty());


//            String sql = "from Crm_staff where 1=1 and crm_post.crm_department.depID=?";
//            List<String> values = new ArrayList<>();
//            values.add(department);

//            List<Crm_staff> beanList = pd.getBeanList();
//
//            for (Crm_staff crm_staff : beanList) {
//                System.out.println(crm_staff);
//
//
//     }

//        staffService.a(department);


//        if (!(department == null) && !Objects.equals(department, "-1")) {
//            String hql = "from Crm_staff where 1=1 and crm_post.crm_department.depID=:department";
//
//
//            Map<String, Object> params = new HashMap<>();
//            params.put("department", department);
//            pd = staffService.findStaff(pc, ps, hql, params);
//
//
//        }


//        if (!(post == null) && !Objects.equals(post, "-1")) {
//        String hql = "from Crm_staff where 1=1 Crm_staff.crm_post.postId";
//        Map<String, Object> params = new HashMap<>();
//        params.put("Crm_staff.crm_post.postId", post);
//        PageBean<Crm_staff> staff = staffService.findStaff(pc, ps, hql, params);
//        }


//        staffService.findAll()

//        staff.getBeanList();


        pd = staffService.findStaff(pc, ps, department, post, staffName);


//        传递 pc, ps 获得 pageBean
//        pd = staffService.findAll(pc, ps);

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


    private List<Crm_department> dep = new ArrayList<>();
    private Set<Crm_post> pos = new HashSet<>();
    private Crm_staff staff;

    /**
     * 用 id查询 员工信息
     */
    public String IdStaff() {

        dep = departmentService.findAll();

        pos = departmentService.findID(depID).getPosts();

//        pos = postService.findAll();

//        for (Crm_post po : pos) {
//            System.out.println(po.getPostId());
//        }

        staff = staffService.findId(staffId);
//        System.out.println(Crm_post);

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

    public List<Crm_department> getDep() {
        return dep;
    }

    public void setDep(List<Crm_department> dep) {
        this.dep = dep;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Set<Crm_post> getPos() {
        return pos;
    }

    public void setPos(Set<Crm_post> pos) {
        this.pos = pos;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Crm_staff getStaff() {
        return staff;
    }

    public void setStaff(Crm_staff staff) {
        this.staff = staff;
    }

    public String getSna() {
        return sna;
    }

    public void setSna(String sna) {
        this.sna = sna;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
