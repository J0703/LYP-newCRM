package com.lanou.teach.action;

import com.lanou.hrd.domain.PageBean;
import com.lanou.teach.domain.Classes;
import com.lanou.teach.domain.Course_type;
import com.lanou.teach.service.ClassesService;
import com.lanou.teach.service.Course_typeService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by dllo on 17/10/28.
 */
@Controller("classesAction")
@Scope("prototype")
public class ClassesAction extends ActionSupport {

    @Resource
    private ClassesService classesService;

    @Resource
    private Course_typeService course_typeService;

    private String name;
    private Date beginTime;
    private Date endTime;
    private String remark;
    private String courseTypeId;


    private PageBean<Classes> pd;

    public String classesPaging(){

        //        获得 当前页码数
        int pc = getPc();
//        指定 每页的记录数
        int ps = 10;
//        传递 pc, ps 获得 pageBean
        pd = classesService.findPaging(pc, ps);


        return SUCCESS;
    }

    //    pc : 页数
    private String pc;

    private int getPc() {
        /*
            1. 得到 pageCode
				> 如果 pc 参数不存在, pc = 1
				> 如果 pc 参数存在, 转成 int 类型
		 */

        String value = pc;

        System.out.println(value);

        if (value == null || value.trim().isEmpty()) {
            return 1;
        }
        return Integer.parseInt(value);
    }


    public String addClasses(){

        Course_type course = course_typeService.findId(courseTypeId);

        Classes classes = new Classes(name, beginTime, endTime, remark, course);


        classesService.add(classes);

//        classesService.add();

        return SUCCESS;
    }

    private Classes classes;

    /**
     * 用 id查询 班级信息
     */
    public String IdClasses() {

        classes = classesService.findID(courseTypeId);

//        classes.getLessonTypeID().getCourseName();
//        System.out.println(classes);

        return SUCCESS;
    }


    //    表单提交过来的文件, 名字与 jsp 页面同名
    private File photo;
    //    提交的文件对应的文件名, 例如 test.png
    private String photoFileName;
    //    提交的文件对应的文件格式, 例如 png
    private String photoContentType;

    //    定义一个供下载的输入流对象, 作为动作方法的 result 返回参数传递给页面
    private InputStream inputStream;
    //    要下载的文件名称
    private String fileName;


    /**
     * 单文件上传
     */
    public String singleUpload(){


//        获取当前项目下的 files 路径
        String path = ServletActionContext.getServletContext().getRealPath("files");

        Classes id = classesService.findID(courseTypeId);

        id.setUploadPath(path);
        id.setUploadFileName(photoFileName);

        Calendar c = Calendar.getInstance();
        Date a = c.getTime();

        id.setUploadTime(a);

        classesService.classesUpdate(id);


        System.out.println("文件路径" + path);

        File destDirectory = new File(path);

//        如果目的文件目录不存在, 则需要创建一下该目录
        if (!destDirectory.exists() || destDirectory.isDirectory()){
            destDirectory.mkdirs();
        }

//        构建一个空文件对象, 用于存储上传的文件
        File file = new File(destDirectory, photoFileName);

        try {
            FileUtils.copyFile(photo, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    /**
     * 文件下载
     */
    public String download() {

//        获得下载路径
        String dirPath = ServletActionContext.getServletContext().getRealPath("files");

//        初始化文件名称
//        System.out.println(fileName);
//        fileName = "1.png";

//        要下载的文件对象
        File file = new File(dirPath, fileName);

        try {
//            构建输入流对象
            inputStream = new FileInputStream(file);

//            将文件名称中包含中文的部分进行浏览器兼容处理,
//            放在 inputStream 赋值之后, 动作方法返回之前
            fileName = filenameEncoding(fileName, ServletActionContext.getRequest(), ServletActionContext.getResponse());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return SUCCESS;
    }


    /**
     * 处理浏览器文件下载包含中文的问题
     * @param filename 要进行中文处理的原文件名称
     * @return 返回处理完成的文件名称
     */
    private String filenameEncoding(String filename, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String agent = request.getHeader("User-Agent"); //         System.out.println(agent);
        if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8"))
                    + "?=";
        } else if (agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, "utf-8");
        } else if (agent.contains("Safari")) {
            filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

    private List<Classes> classesList;

    /**
     * 通过课程查班级
     */
    public String findByCourse(){
        Map<String, Object> params = new HashMap<>();
        params.put("courseTypeId",courseTypeId);
        classesList = classesService.findByCourse(params);
        return SUCCESS;
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }


    public PageBean<Classes> getPd() {
        return pd;
    }

    public void setPd(PageBean<Classes> pd) {
        this.pd = pd;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
