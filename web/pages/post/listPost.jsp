<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[职务管理]</td>
   
    <td width="57%"align="right">
    	<%--添加职务 --%>
       <%--<a href="${pageContext.request.contextPath}/pages/post/addOrEditPost.jsp">--%>
       <a href="${pageContext.request.contextPath}/departFind.action">
       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
       </a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="6%" align="center">部门名称</td>
    <td width="6%" align="center">职务名称</td>
    <td width="7%" align="center">编辑</td>
  </tr>

    <c:forEach items="${pd.beanList}" var="post" varStatus="a">

    <c:if test="${a.index%2==0}">
        <tr class="tabtd1">
    </c:if>
    <c:if test="${a.index%2!=0}">
        <tr class="tabtd2">
    </c:if>

        <td align="center">${post.crm_department.depName}</td>
        <td align="center">${post.postName}</td>
        <td width="7%" align="center">
            <a href="${pageContext.request.contextPath}/IdPost.action?postName=${post.postName}&postId=${post.postId}&depID=${post.crm_department.depID}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
        </td>
    </tr>
    </c:forEach>

    <%--<tr class="tabtd1">--%>
        <%--<td align="center">${depart.depName}</td>--%>
        <%--<td width="7%" align="center">--%>
            <%--<a href="${pageContext.request.contextPath}/IdDepart.action?depName=${depart.depName}&depID=${depart.depID}"><img--%>
                    <%--src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
        <%--</td>--%>




  	<%--<tr class="tabtd1">--%>
	    <%--<td align="center">教学部 </td>--%>
	    <%--<td align="center">总监 </td>--%>
	  	<%--<td width="7%" align="center">--%>
	  		<%--<a href="${pageContext.request.contextPath}/pages/post/addOrEditPost.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>--%>
	  	<%--</td>--%>
	  <%--</tr>--%>
  
  	<%--<tr class="tabtd2">--%>
	    <%--<td align="center">教学部 </td>--%>
	    <%--<td align="center">讲师 </td>--%>
	  	<%--<td width="7%" align="center">--%>
	  		<%--<a href="${pageContext.request.contextPath}/pages/post/addOrEditPost.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>--%>
	  	<%--</td>--%>
	  <%--</tr>--%>
</table>



 <table border="0" cellspacing="0" cellpadding="0" align="center">
     <tr>
         <td align="right">
             <span>第${pd.pc}页/共${pd.tp}页</span>
             <span>
        	<a href="postPaging.action">[首页]</a>&nbsp;&nbsp;

            <c:if test="${pd.pc > 1}">
                <a href="postPaging.action?pc=${pd.pc-1}">[上一页]</a>&nbsp;&nbsp;
            </c:if>

            <c:choose>
                <c:when test="${pd.tp<=10}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pd.tp}"/>
                </c:when>
                <%-- 总页数>10, 使用计算公式计算 end, begin --%>
                <c:otherwise>
                    <c:set var="begin" value="${pd.pc - 5}"/>
                    <c:set var="end" value="${pd.pc + 4}"/>
                    <%-- 头溢出 --%>
                    <c:if test="${begin < 1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="10"/>
                    </c:if>
                    <%-- 尾溢出 --%>
                    <c:if test="${end > pd.tp}">
                        <c:set var="begin" value="${pd.tp - 9}"/>
                        <c:set var="end" value="${pd.tp}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>

            <c:forEach var="i" begin="${begin}" end="${end}">
                <c:choose>
                    <c:when test="${pd.pc eq i}">
                        [${i}]
                    </c:when>
                    <c:otherwise>
                        <a href="postPaging.action?pc=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${pd.pc < pd.tp}">
                <a href="postPaging.action?pc=${pd.pc+1}">[下一页]</a>&nbsp;&nbsp;
            </c:if>
            <a href="postPaging.action?pc=${pd.tp}">[尾页]</a>

            <%--<a href="#">[下一页]</a>&nbsp;&nbsp;--%>
            <%--<a href="#">[尾页]</a>--%>
        </span>
         </td>
     </tr>
 </table>

<%--<table border="0" cellspacing="0" cellpadding="0" align="center">--%>
  <%--<tr>--%>
    <%--<td align="right">--%>
    	<%--<span>第1/3页</span>--%>
        <%--<span>--%>
        	<%--<a href="#">[首页]</a>&nbsp;&nbsp;--%>
            <%--<a href="#">[上一页]</a>&nbsp;&nbsp;--%>
            <%--<a href="#">[下一页]</a>&nbsp;&nbsp;--%>
            <%--<a href="#">[尾页]</a>--%>
        <%--</span>--%>
    <%--</td>--%>
  <%--</tr>--%>
<%--</table>--%>
</body>
</html>
