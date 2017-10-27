package com.lanou.hrd.service;

import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface DepartmentService {

    void addDepart(Crm_department crm_department);

    List<Crm_department> findAll();

    PageBean<Crm_department> findPaging(int pc, int ps);

    void departUpdate(Crm_department crm_department);

    Crm_department findID(String depID);

    Crm_department findSingle(String depName);

}
