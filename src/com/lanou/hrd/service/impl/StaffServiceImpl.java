package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Crm_staff;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.StaffService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by dllo on 17/10/24.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;

    @Override
    public Crm_staff login(String loginName, String loginPwd) {
        return staffDao.login(loginName, loginPwd);
    }

    @Override
    public PageBean<Crm_staff> findAll(int pc, int ps) {
        return staffDao.findAll(pc, ps);
    }

    @Override
    public void add(Crm_staff crm_staff) {
        staffDao.add(crm_staff);
    }


//    public PageBean<Crm_staff> findStaff(int pc, int ps, String hql, Map<String, Object> params){

//        String hql = "from Crm_staff";

//        Object[] v = values.toArray();

//        if (!(department == null) && !Objects.equals(department, "-1")) {
//            String hql = "from Crm_staff where 1=1 and crm_post.crm_department.depID=:department";
//
//
//            Map<String, Object> params = new HashMap<>();
//            params.put("department", department);
//            pd = staffService.findStaff(pc, ps, hql, params);
//
//
//        }

//        return staffDao.findStaff(pc, ps, hql, params);

//    }

    @Override
    public PageBean<Crm_staff> findStaff(int pc, int ps, String department, String post, String staffName) {

        StringBuffer sb = new StringBuffer();
        Map<String, Object> params = new HashMap<>();

        sb.append("from Crm_staff where 1=1");


        if (!(department == null) && !Objects.equals(department, "-1")) {
//            String hql = "from Crm_staff where 1=1 and crm_post.crm_department.depID=:department";

            sb.append(" and crm_post.crm_department.depID=:department");

            params.put("department", department);
//            Map<String, Object> params = new HashMap<>();
        }

        if (!(post == null) && !Objects.equals(post, "-1")){
            sb.append(" and crm_post.postId=:post");
            params.put("post", post);
        }

        if (!(staffName == null)){
            sb.append(" and staffName like :staff");
            params.put("staff", "%" + staffName + "%");
        }

        String hql = String.valueOf(sb);

        return staffDao.findStaff(pc, ps, hql, params);

    }

    public Crm_staff findId(String staffId){

        return staffDao.findById(staffId, Crm_staff.class);

    }

    @Override
    public void staffUpdate(Crm_staff crm_staff){
        staffDao.upStaff(crm_staff);
//        staffDao.update(crm_staff);
    }

//    public void a(String department){
//
//        System.out.println(Objects.equals(department, ""));
//        System.out.println(department);
//        System.out.println(department == null);
//    }


}
