package com.lanou.hrd.service;

import com.lanou.hrd.domain.Crm_post;
import com.lanou.hrd.domain.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface PostService {

    void addDepart(Crm_post crm_post);

    PageBean<Crm_post> findPaging(int pc, int ps);

    List<Crm_post> findAll();

    void postUpdate(Crm_post crm_post);

    Crm_post findID(String postId);

    Crm_post findSingle(String postName);

}
