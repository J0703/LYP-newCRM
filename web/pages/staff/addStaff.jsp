<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="${pageContext.request.contextPath}/addStaff.action" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="${loginName}"/> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value="${loginPwd}"/> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="sna" id="staffAction_add_staffName" value="${sna}"/> </td>

		 <c:set var="gender" value="${gender}"/>
		 <c:set var="nan" value="男"/>
		 <c:set var="nv" value="女"/>

	    <td>性别：</td>
	    <td><input type="radio" name="gender" <c:if test="${fn:contains(gender, nan)}">checked="checked"</c:if> value="男"/>男
	    	<input type="radio" name="gender" <c:if test="${fn:contains(gender, nan)}">checked="checked"</c:if> value="女"/>女
		</td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<%--<select name="crmPost.crmDepartment.depId"onchange="changePost(this)">--%>
	    	<select name="department" id="depID">
			    <option value="-1">----请--选--择----</option>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000001">教学部</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select id="post" name="pid">
	    		<option value="-1">----请--选--择----</option>
	    	</select>
	    </td>
	  </tr>
	   <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="${onDutyDate}" readonly="readonly"  onfocus="c.showMoreDay=true; c.show(this);" />
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

		$.post("depart", function (date) {
			var _html = "";

			for (var i = 0; i < date.length; i++) {

				_html += "<option value='" + date[i].depID + "'>" + date[i].depName + "</option>"

			}

			$("#department").empty();

			$("#department").append("<option value='-1'>--请选择--</option>");

			$("#department").append(_html);
		})

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
