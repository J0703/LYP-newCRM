package com.lanou.teach.dao;

import com.lanou.hrd.dao.BaseDao;
import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.domain.Course_type;

import java.util.Map;

/**
 * Created by dllo on 17/10/31.
 */
public interface Course_typeDao extends BaseDao<Course_type> {

    PageBean<Course_type> findCourse(int pc, int ps, String hql, Map<String, Object> params);



}
