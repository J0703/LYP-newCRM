package com.lanou.teach.service.impl;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.dao.Course_typeDao;
import com.lanou.teach.domain.Course_type;
import com.lanou.teach.service.Course_typeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/31.
 */
@Service("course_typeService")
public class Course_typeServiceImpl implements Course_typeService {

    @Resource
    private Course_typeDao course_typeDao;

    @Override
    public void add(Course_type course_type) {
        course_typeDao.add(course_type);
    }

    @Override
    public PageBean<Course_type> findType(int pc, int ps, String courName, String mark, int totalStart,
                                           int totalEnd, double lessonCostStart, double lessonCostEnd) {


        StringBuffer sb = new StringBuffer();
        Map<String, Object> params = new HashMap<>();
        sb.append("from Course_type where 1=1");

        if (!(courName == null)){
            sb.append(" and courseName like :courName");
            params.put("courName", "%" + courName + "%");
        }

        if (!(mark == null)){
            sb.append(" and remark like :mark");
            params.put("mark", "%" + mark + "%");
        }

        if (!(totalStart == 0)){
            sb.append(" and total>:totalStart");
            params.put("totalStart", totalStart);
        }

        if (!(totalEnd == 0)){
            sb.append(" and total<:totalEnd");
            params.put("totalEnd", totalEnd);
        }

        if (!(lessonCostStart == 0.00)){
            sb.append(" and courseCost>:lessonCostStart");
            params.put("lessonCostStart", lessonCostStart);
        }

        if (!(lessonCostEnd == 0.00)){
            sb.append(" and courseCost<:lessonCostEnd");
            params.put("lessonCostEnd", lessonCostEnd);
        }


        String hql = String.valueOf(sb);

        return course_typeDao.findCourse(pc, ps, hql, params);
    }

    @Override
    public Course_type findId(String ctid) {
        return course_typeDao.findById(ctid, Course_type.class);
    }

    @Override
    public void upCourse(Course_type course_type) {

        System.out.println(course_type.getCourseTypeID());

        course_typeDao.update(course_type);
    }

    @Override
    public List<Course_type> findAll() {

        String hql = "from Course_type";

        return course_typeDao.findAll(hql);
    }

    @Override
    public Course_type findSingle(Class<Course_type> courseTypeClass, String courseTypeId) {
        return course_typeDao.get(courseTypeClass,courseTypeId);
    }

}