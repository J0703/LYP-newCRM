package com.lanou.hrd.domain;

import java.util.List;

/**
 *  第 M/N 页 首页 上一页 [1] [2] ... [10] 下一页 尾页 [ ]Go!
 *  分页的 bean
 *  1. 当前页码: pageCode , pc
 *  2. 总页数: totalPage, tp   总记录数/每页记录数
 *  3. 总记录数: totalRecord , tr   dao: 查询 select count(*)
 *  4. 每页记录数: pageSize, ps  10
 *  5. 当前页的数据: beanList bl
 *  6. url
 */
public class PageBean<T> {

    private int pc; // 当前页码 pageCode
//    private int tp; // 总页码数 totalPage
    private int tr; // 总记录数 totalRecord
    private int ps; // 每页记录数 pageSize
    private List<T> beanList; // 当前页记录
    private String url; // url后面的条件

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

//    计算总页数
    public int getTp() {
//        总记录数tr /每页记录数ps
        int tp = tr/ps;
        return tr%ps == 0 ? tp : tp + 1;
    }

//    public void setTp(int tp) {
//        this.tp = tp;
//    }

    public int getTr() {
        return tr;
    }

    public void setTr(int tr) {
        this.tr = tr;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
