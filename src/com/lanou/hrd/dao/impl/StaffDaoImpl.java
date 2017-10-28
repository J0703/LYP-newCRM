package com.lanou.hrd.dao.impl;

import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class StaffDaoImpl extends BaseDaoImpl<Crm_staff> implements StaffDao {


    @Override
    public Crm_staff login(String loginName, String loginPwd) {

        Object[] params = {loginName, loginPwd};

        List<Crm_staff> crm_staffs =
                (List<Crm_staff>) getHibernateTemplate().find("from Crm_staff where loginName=? and loginPwd=?", params);


        if (crm_staffs.size() > 0) {
            return crm_staffs.get(0);
        } else {
            return null;
        }

//        return crm_staffs.size() > 0;
    }

    public int count(){
//        Session session = currentSession();
//
//        Query query = session.createQuery("from Crm_staff ");
//        int size = query.list().size();
//        System.out.println(size);
//
//        return size;

        return getHibernateTemplate().find("from Crm_staff ").size();

    }

//    分页查询
    public PageBean<Crm_staff> findAll(int pc, int ps){


//        创建pb
        PageBean<Crm_staff> pb = new PageBean<>();

//			设置 pc, ps
        pb.setPc(pc);
        pb.setPs(ps);

        Session session = currentSession();

//			得到 tr, 总记录数
        int tr = count();
        pb.setTr(tr);

        Query query = session.createQuery("from Crm_staff ");

        query.setFirstResult(((pc - 1) * ps));
        query.setMaxResults((pc * ps));

        List<Crm_staff> crm_staffs = query.list();

        pb.setBeanList(crm_staffs);

        return pb;

    }

    public int tr(String hql, Map<String, Object> params){

//        String sql = "from Crm_staff where 1=1 and crm_post.crm_department.depID=:department";
//
//        Map<String, Object> params = new HashMap<>();
//
//        params.put("department", "2c90906e5f5658e5015f565923d80000");

//        for (Object value : values) {
//
//        }



       Session session = currentSession();

        Query query = session.createQuery(hql);

        if (params != null && !params.isEmpty()){
//            遍历参数
            for (String key : params.keySet()) {
//                设置查询语句中的 key 与 value
                query.setParameter(key, params.get(key));
            }
        }

        int size = query.list().size();

        System.out.println(size);

        return size;

//        List<Object> objects = Arrays.asList(values);
//
//
//        return getHibernateTemplate().find(hql, values).size();

    }

    //    分页查询
    public PageBean<Crm_staff> findStaff(int pc, int ps, String hql, Map<String, Object> params){


//        创建pb
        PageBean<Crm_staff> pb = new PageBean<>();

//			设置 pc, ps
        pb.setPc(pc);
        pb.setPs(ps);

        Session session = currentSession();

//			得到 tr, 总记录数
        int tr = tr(hql, params);
        pb.setTr(tr);

        Query query = session.createQuery(hql);

        if (params != null && !params.isEmpty()){
//            遍历参数
            for (String key : params.keySet()) {
//                设置查询语句中的 key 与 value
                query.setParameter(key, params.get(key));
            }
        }

        query.setFirstResult(((pc - 1) * ps));
        query.setMaxResults((pc * ps));

        List<Crm_staff> crm_staffs = query.list();

        pb.setBeanList(crm_staffs);

        return pb;

    }


    public void upStaff(Crm_staff crm_staff) {

        Session session = currentSession();

        session.merge(crm_staff);

//        getHibernateTemplate().update(crm_staff);
    }


}
