package com.lanou.teach.service;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.domain.Classes;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/28.
 */
public interface ClassesService {

    PageBean<Classes> findPaging(int pc, int ps);

    void add(Classes classes);

    List<Classes> findAll();

    Classes findID(String classesId);

    Classes findSingle(String classesName);

    void classesUpdate(Classes classes);

    List<Classes> findByCourse(Map<String, Object> params);

    void save(Classes classes2);

    Classes findSingle(Class<Classes> classesClass, String classId);

}
