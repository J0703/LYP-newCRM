<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
	<script src="../../jquery-3.2.1.js" type="text/javascript"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="${pageContext.request.contextPath}/updateStaff.action?staffId=${staff.staffId}" method="post">
	
	<%--<input type="hidden" name="staffId" value="2c9091c14c78e58b014c78e7ecd90007"/>--%>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="${staff.loginName}" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value="${staff.loginPwd}" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="sna" value="${staff.staffName}" /> </td>
	    <td>性别：</td>
		 <c:set var="gender" value="${staff.gender}"/>
		 <c:set var="nan" value="男"/>
		 <c:set var="nv" value="女"/>
	    <td>
	    	<input type="radio" name="gender" <c:if test="${fn:contains(gender, nan)}">checked="checked"</c:if> value="男"/>男
	    	<input type="radio" name="gender" <c:if test="${fn:contains(gender, nv)}">checked="checked"</c:if> value="女"/>女
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">

	    	<select name="depID" id="department">
			<option value="-1">----请--选--择----</option>
			<c:set var="a" value="${depID}"/>
			<c:forEach items="${dep}" var="dep">
				<c:set var="b" value="${dep.depID}"/>
				<option value="${dep.depID}" <c:if test="${a eq b}">selected="selected"</c:if>>
						${dep.depName}
				</option>
			</c:forEach>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">


	    	<select name="pid" id="post">
				<option value="-1">----请--选--择----</option>
				<c:set var="c" value="${pid}"/>
				<c:forEach items="${pos}" var="pos">
					<c:set var="d" value="${pos.postId}"/>
					<option value="${pos.postId}" <c:if test="${c eq d}">selected="selected"</c:if>>
					${pos.postName}
					</option>
				</c:forEach>
			</select>
			    <%--<option value="">----请--选--择----</option>--%>
			    <%--<option value="2c9091c14c78e58b014c78e6b34a0003">总监</option>--%>
			    <%--<option value="2c9091c14c78e58b014c78e6d4510004" selected="selected">讲师</option>--%>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="${staff.onDutyDate}" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>

<font color="#ff0000">
	<s:actionerror/>
</font>

</body>
<script>
	window.onload = function () {

		$("#department").change(function () {

			$("#post").empty();

			$("#post").append("<option value='-1'>--请选择--</option>");

			$.post("post","department="+$("#department").val(),function (date) {

				var _html = "";

				for (var i = 0; i < date.length; i++) {

					_html += "<option value='" + date[i].postId + "'>" + date[i].postName + "</option>"

				}

				$("#post").append(_html);

			})

		})

	}
</script>
</html>
