package com.lanou.hrd.dao.impl;

import com.lanou.hrd.dao.BaseDao;
import com.lanou.hrd.domain.PageBean;
import com.lanou.util.PageHibernateCallback;
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

    /**
     * 通过id获取
     *
     * @param c  Class
     * @param id 序列化id
     * @return
     */
    @Override
    public T get(Class<T> c, Serializable id) {
        Session session = currentSession();
        // 根据主键id查询某个对象
        T t = (T) session.get(c, id);
        return t; // 返回查询到的t对象
    }

    /**
     * 保存
     *
     * @param t 保存对象
     */
    @Override
    public void save(T t) {
        Session session = currentSession();
        session.save(t);
    }

    /**
     * 分页查询获取数据总记录条数
     *
     * @param hql
     */
    @Override
    public int getTotalRecord(String hql) {
        List<Long> find = (List<Long>) this.getHibernateTemplate().find(hql);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 分页查询
     *
     * @param hql        查询语句
     * @param startIndex 初始下标
     * @param pageSize   查询个数
     */
    @Override
    public List<T> findALL(String hql, int startIndex, int pageSize) {
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql, startIndex, pageSize));
    }

    /**
     * 高级查询查询数据总记录条数
     *
     * @param hql    查询语句
     * @param params 参数
     */
    @Override
    public int getTotalRecordT(String hql, List<Object> params) {
        List<Long> find = (List<Long>) this.getHibernateTemplate().find(hql, params.toArray());
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    /**
     * 模糊分页查询
     *
     * @param hql        查询语句
     * @param params     参数
     * @param startIndex 初始下标
     * @param pageSize   查询数量
     */
    @Override
    public List<T> findByCD(String hql, List<Object> params, int startIndex, int pageSize) {
        return this.getHibernateTemplate().execute(
                new PageHibernateCallback<T>(hql, params.toArray(), startIndex, pageSize));
    }

    @Override
    public List<T> findByQQ(String s, Object[] objects) {
        Session session = currentSession();
        Query query = session.createQuery(s);
        for (int i = 0; i < objects.length; i++) {
            query.setParameter(i,objects[i]);
        }

        return query.list();
    }


    /**
     * 条件查询
     *
     * @param hql    查询语句
     * @param params 参数
     * @return
     */
    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<T> list = query.list();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 条件查询
     *
     * @param hql    查询语句
     * @param params 参数
     * @return
     */
    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<T> tList = query.list();
        return tList;
    }


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
