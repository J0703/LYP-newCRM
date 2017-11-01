package com.lanou.hrd.test;

import com.lanou.hrd.dao.DepartmentDao;
import com.lanou.hrd.dao.StaffDao;
import com.lanou.hrd.domain.Crm_department;
import org.apache.commons.collections.map.HashedMap;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class MainTest {
    private ApplicationContext context;
    //
//    private SessionFactory sessionFactory;
//
//    @Test
//    public void test(){
//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//    }

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void test() {
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        System.out.println(staffDao.login("1", "1"));
    }

    @Test
    public void pb() {
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");
        staffDao.findAll(1, 10);
    }

    @Test
    public void findStaff(){
        StaffDao staffDao = (StaffDao) context.getBean("staffDao");

//        Map<String, Object> values = new HashedMap();
//        values.put("1", "1");
//        values.put("1", "1");
//        values.put("1", "1");
//
//
//        if(values != null) {
//            for(int i = 0; i < values.length; ++i) {
//                queryObject.setParameter(i, values[i]);
//            }
//        }


//        String hql = "select new com.lanou.hrd.domain.Crm_staff(st.staffId, st.loginName, st.loginPwd, st.staffName, st.gender, st.onDutyDate, st.crm_post) from Crm_staff st, Crm_post po where depId=? and st.postID=po.postId";
//        String hql = "select st.staffId from Crm_staff st, Crm_post po where depId=? and st.postID=po.postId";
        String hql = "from Crm_staff st, Crm_post po where st.postId = po.postId";

//        String hql = "from Crm_staff where postId=?";

//        Object[] params = {"2c90906e5f57f777015f57f854840004"};

//        staffDao.find(hql, params);

        staffDao.findAll(hql);

    }

    @Test
    public void add() {
        Crm_department department = new Crm_department();
        department.setDepName("教学部");

        DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
        departmentDao.add(department);

        List<Crm_department> departments = departmentDao.findAll("from Crm_department");
        for (Crm_department crm_department : departments) {
            System.out.println(crm_department);
        }

//        getHibernateTemplate().save(department);
//
//        Crm_post post = new Crm_post("2", "偶像");
//
//        department.getPosts().add(post);
//
//        Crm_staff staff = new Crm_staff("小黑", "小黑", "小黑", "小黑", date);
//
//        post.getStaffs().add(staff);

//        getHibernateTemplate().save(department);


    }


    @Test
    public void EncoderByMd5() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String str = "22";

        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));

//        EkvRKWvsDZ2Tx7Uqca2NWw==

        System.out.println(newstr);



    }



}
