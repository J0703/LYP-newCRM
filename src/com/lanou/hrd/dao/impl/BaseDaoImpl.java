package com.lanou.hrd.dao.impl;

import com.lanou.hrd.dao.BaseDao;
import com.lanou.hrd.domain.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    @Override
    public void add(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {

        Session session = currentSession();

        T t = (T) session.get(tClass, id);

        return t;

    }

    @Override
    public List<T> findAll(String hql) {

        List<T> tList = (List<T>) getHibernateTemplate().find(hql);

        return tList;
    }

    @Override
    public List<T> find(String hql, Object[] params) {

        List<T> tList = (List<T>) getHibernateTemplate().find(hql, params);

        return tList;
    }

    @Override
    public T findSingle(String hql, Object[] params) {

        List<T> tList = (List<T>) getHibernateTemplate().find(hql, params);

        if (tList.size() > 0) {
            return tList.get(0);
        } else {
            return null;
        }

    }

    //    查找总页数
    private int count(String hql) {

        return getHibernateTemplate().find(hql).size();

    }

    //    分页查询
    public PageBean<T> findPaging(int pc, int ps, String hql) {

//        创建pb
        PageBean<T> pb = new PageBean<>();

//			设置 pc, ps
        pb.setPc(pc);
        pb.setPs(ps);

        Session session = currentSession();

//			得到 tr, 总记录数
        int tr = count(hql);
        pb.setTr(tr);

        Query query = session.createQuery(hql);

        query.setFirstResult(((pc - 1) * ps));
        query.setMaxResults(ps);

        List<T> tList = query.list();

        pb.setBeanList(tList);

        return pb;

    }

    /**
     * 查找并更改
     */
    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }


}
