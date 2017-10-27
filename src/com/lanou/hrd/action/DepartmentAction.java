package com.lanou.hrd.action;

import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * Created by dllo on 17/10/25.
 */
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends ActionSupport {

    @Resource
    private DepartmentService departmentService;

    private String depName;

    private String depID;


    /**
     * 添加部门
     */
    public String addDepart() {

        Crm_department depart = departmentService.findSingle(depName);

        if (depart != null) {

            addActionError("添加部门名称相同, 请重新填写");

            return INPUT;

        } else {

            if (!StringUtils.isEmpty(depID)) {

//        使用 findID 方法 获取 department 的全部数值, 如果有
                Crm_department department = departmentService.findID(depID);

                department.setDepName(depName);

                departmentService.departUpdate(department);

            } else {

                Crm_department crm_department = new Crm_department(depName);

                departmentService.addDepart(crm_department);

            }
        }

        return SUCCESS;
    }

    /**
     * 如果id不存在代表没有添加
     * 如果id存在代表更改
     */
    public void validateAddDepart() {

        if (StringUtils.isEmpty(depName)) {
            addActionError("添加部门名称不能为空, 请重新填写");
        }

    }

    private List<Crm_department> departments;

    /**
     * 查询所有部门
     */
    public String findAll() {

        departments = departmentService.findAll();

//        for (Crm_department department : departments) {
//            System.out.println(department);
//        }


        return SUCCESS;
    }

    PageBean<Crm_department> pd;

    /**
     * 分页查询所有部门
     */
    public String findPaging() {

//        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;
//        传递 pc, ps 获得 pageBean
        pd = departmentService.findPaging(pc, ps);

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

    /**
     * 用 id查询 部门信息
     */
    public String IdDepart() {

        Crm_department crm_department = departmentService.findID(depID);

        System.out.println(crm_department);

        return SUCCESS;
    }


    public PageBean<Crm_department> getPd() {
        return pd;
    }

    public void setPd(PageBean<Crm_department> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public List<Crm_department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Crm_department> departments) {
        this.departments = departments;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }
}
