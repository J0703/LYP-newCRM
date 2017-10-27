package com.lanou.hrd.dao.impl;

import com.lanou.hrd.dao.DepartmentDao;
import com.lanou.hrd.domain.Crm_department;

/**
 * Created by dllo on 17/10/25.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Crm_department> implements DepartmentDao {


//    /**
//     * 添加部门
//     * @param crm_department 部门内容
//     */
//    public void add(Crm_department crm_department){
//
//        getHibernateTemplate().save(crm_department);
//
//    }


//    public List<Crm_department> findAll(String hql){
//
//        System.out.println("11");
//
//        Session session = currentSession();
//
//        Query query = session.createQuery("from Crm_department");
//
//        List<Crm_department> list = query.list();
//
////        List<Crm_department> list = (List<Crm_department>) getHibernateTemplate().find("from Crm_department");
//
//        return list;
//
//    }

}
