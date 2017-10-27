package com.lanou.hrd.service.impl;

import com.lanou.hrd.dao.PostDao;
import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.domain.PageBean;
import com.lanou.hrd.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    @Resource
    private PostDao postDao;

    @Override
    public void addDepart(Crm_post crm_post) {
        postDao.add(crm_post);
    }

    @Override
    public PageBean<Crm_post> findPaging(int pc, int ps) {
        String hql = "from Crm_post";

        return postDao.findPaging(pc, ps, hql);
    }

    @Override
    public List<Crm_post> findAll() {

        String hql = "from Crm_department";

        return postDao.findAll(hql);
    }

    @Override
    public void postUpdate(Crm_post crm_post) {
        postDao.update(crm_post);
    }

    @Override
    public Crm_post findID(String postId) {
        return postDao.findById(postId, Crm_post.class);
    }

    @Override
    public Crm_post findSingle(String postName) {
        String hql = "from Crm_post where postName=?";

        Object[] params = {postName};

        return postDao.findSingle(hql, params);
    }

}
