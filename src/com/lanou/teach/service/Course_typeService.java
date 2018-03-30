package com.lanou.teach.service;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.domain.Course_type;

import java.util.List;

/**
 * Created by dllo on 17/10/31.
 */
public interface Course_typeService {

    void add(Course_type course_type);

    PageBean<Course_type> findType(int pc, int ps, String courName, String mark, int totalStart,
                                    int totalEnd, double lessonCostStart, double lessonCostEnd);

    Course_type findId(String ctid);

    void upCourse(Course_type course_type);

    List<Course_type> findAll();

    Course_type findSingle(Class<Course_type> courseTypeClass, String courseTypeId);

}
