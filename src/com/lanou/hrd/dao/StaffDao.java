package com.lanou.hrd.dao;

import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;

import java.util.List;
import java.util.Map;


/**
 * Created by dllo on 17/10/24.
 */
public interface StaffDao extends BaseDao<Crm_staff> {

    Crm_staff login(String loginName, String loginPwd);

    PageBean<Crm_staff> findAll(int pc, int ps);

    PageBean<Crm_staff> findStaff(int pc, int ps, String hql, Map<String, Object> params);

    void upStaff(Crm_staff crm_staff);
}
