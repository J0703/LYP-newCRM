package com.lanou.teach.dao.impl;

import com.lanou.hrd.dao.impl.BaseDaoImpl;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.dao.Course_typeDao;
import com.lanou.teach.domain.Course_type;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/31.
 */
public class Course_typeDaoImpl extends BaseDaoImpl<Course_type> implements Course_typeDao {


    private int tr(String hql, Map<String, Object> params){

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

    }

    //    分页查询
    public PageBean<Course_type> findCourse(int pc, int ps, String hql, Map<String, Object> params){


//        创建pb
        PageBean<Course_type> pb = new PageBean<>();

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

        List<Course_type> course_types = query.list();

        pb.setBeanList(course_types);

        return pb;

    }

}
