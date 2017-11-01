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
    <td width="39%" align="left">[课程类别]</td>
   
    <td width="57%"align="right">
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
			<img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" />
		</a>      
    	<%--编辑前：添加类别 --%>
    	<a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp">
	       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<%--条件查询 start --%>

<form action="${pageContext.request.contextPath}/coursePaging.action" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">课程类别：</td>
	    <td><input type="text" name="courName" size="30" value="" /></td>
	  </tr>
	  <tr>
	    <td >课程简介：</td>
	    <td > <input type="text" name="mark" size="30" value="" /></td>
	  </tr>
	  <tr>  
	    <td >总学时：</td>
	    <td ><input type="text" name="totalStart" size="12" value="" placeholder="请输入整数"  maxlength="15"/>  至  <input type="text" name="totalEnd" size="12" value="" placeholder="请输入整字"  maxlength="15"/></td>
	  </tr>
	  <tr>
	    <td>课程费用：</td>
	    <td ><input type="text" name="lessonCostStart" size="12" value="" placeholder="请输入数字"  maxlength="15"/> 至 <input type="text" name="lessonCostEnd" size="12" value="" placeholder="请输入数字"  maxlength="15"/></td>
	  </tr>
	</table>
</form>

<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="14%" align="center">名称</td>
    <td width="33%" align="center">简介</td>
    <td width="13%" align="center">总学时</td>
    <td width="18%" align="center">收费标准</td>
	<td width="11%" align="center">编辑</td>
  </tr>
  <%--数据展示，单行：tabtd1；双行：tabtd2 --%>

	<c:forEach items="${pd.beanList}" var="course" varStatus="a">
	<c:if test="${a.index%2==0}">
	<tr class="tabtd1">
		</c:if>
		<c:if test="${a.index%2!=0}">
	<tr class="tabtd2">
		</c:if>

		<td align="center">${course.courseName}</td>
		<td align="center">${course.remark}</td>
		<td align="center">${course.total}</td>
		<td align="center">${course.courseCost}</td>
		<td width="7%" align="center">

			<a href="${pageContext.request.contextPath}/IdCourse.action?ctid=${course.courseTypeID}"><img
					src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
		</td>
		</c:forEach>

   <%--<tr class="tabtd1">--%>
	    <%--<td align="center">JavaEE </td>--%>
	    <%--<td align="center"> </td>--%>
	    <%--<td align="center">1000</td>--%>
	    <%--<td align="center">3000.0</td>--%>
	  	<%--<td width="11%" align="center">--%>
	  		<%----%>
	  		<%--<a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>--%>
	  	<%--</td>--%>
	  <%--</tr>--%>
  <%----%>
 <%----%>
	  <%--<tr class="tabtd2">--%>
	    <%--<td align="center">JavaEE </td>--%>
	    <%--<td align="center"> </td>--%>
	    <%--<td align="center">6000</td>--%>
	    <%--<td align="center">18000.0</td>--%>
	  	<%--<td width="11%" align="center">--%>
	  		<%----%>
	  		<%--<a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>--%>
	  	<%--</td>--%>
	  <%--</tr>--%>

 
</table>

 <table border="0" cellspacing="0" cellpadding="0" align="center">
	 <tr>
		 <td align="right">
			 <span>第${pd.pc}页/共${pd.tp}页</span>
			 <span>
        	<a href="findAll.action">[首页]</a>&nbsp;&nbsp;

            <c:if test="${pd.pc > 1}">
				<a href="findAll.action?pc=${pd.pc-1}">[上一页]</a>&nbsp;&nbsp;
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
						<a href="findAll.action?pc=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

            <c:if test="${pd.pc < pd.tp}">
				<a href="findAll.action?pc=${pd.pc+1}">[下一页]</a>&nbsp;&nbsp;
			</c:if>
            <a href="findAll.action?pc=${pd.tp}">[尾页]</a>
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
