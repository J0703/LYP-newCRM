package com.lanou.teach.service.impl;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.dao.ClassesDao;
import com.lanou.teach.domain.Classes;
import com.lanou.teach.service.ClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/28.
 */
@Service("classesService")
public class ClassesServiceImpl implements ClassesService {

    @Resource
    private ClassesDao classesDao;

    @Override
    public PageBean<Classes> findPaging(int pc, int ps) {

        String hql = "from Classes";

        return classesDao.findPaging(pc, ps, hql);

    }

    @Override
    public void add(Classes classes) {
        classesDao.add(classes);
    }

    @Override
    public List<Classes> findAll() {

        String hql = "from Classes";

        return classesDao.findAll(hql);
    }

    @Override
    public Classes findID(String classesId) {
        return classesDao.findById(classesId, Classes.class);
    }

    @Override
    public Classes findSingle(String name) {

        String hql = "from Classes where name=?";

        Object[] params = {name};

        return classesDao.findSingle(hql, params);
    }

    @Override
    public void classesUpdate(Classes classes) {
        classesDao.update(classes);
    }

    @Override
    public List<Classes> findByCourse(Map<String, Object> params) {
        String hql = "from Classes where lessonTypeId =:courseTypeId";
        return classesDao.find(hql,params);
    }

    @Override
    public void save(Classes classes2) {
        classesDao.save(classes2);
    }

    @Override
    public Classes findSingle(Class<Classes> classesClass, String classId) {
        return classesDao.get(classesClass,classId);
    }

}
