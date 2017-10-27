package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.DepartmentDao;
import com.lanou.hrd.domain.Crm_department;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.DepartmentService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    public void addDepart(Crm_department crm_department){
        departmentDao.add(crm_department);
    }

    @Override
    public List<Crm_department> findAll() {

        String hql = "from Crm_department";

        return departmentDao.findAll(hql);
    }

    @Override
    public PageBean<Crm_department> findPaging(int pc, int ps) {

        String hql = "from Crm_department";

        return departmentDao.findPaging(pc, ps, hql);
    }

    @Override
    public Crm_department findID(String depID){
        return departmentDao.findById(depID, Crm_department.class);
    }

    @Override
    public void departUpdate(Crm_department crm_department){
        departmentDao.update(crm_department);
    }

    @Override
    public Crm_department findSingle(String depName){

        String hql = "from Crm_department where depName=?";

        Object[] params = {depName};

        return departmentDao.findSingle(hql, params);

    }


}
