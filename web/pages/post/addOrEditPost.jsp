<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script src="../../jquery-3.2.1.js" type="text/javascript"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[职务管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="${pageContext.request.contextPath}/addPost.action?postId=${postId}&depID=${depID}" method="post">
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <tr>
            <td>选择部门：</td>
            <td><select name="department" id="department">
                <%--<option value="${depID}" id="dep"></option>--%>

                <%--<c:if test="${a.index%2==0}">--%>
                <%--<tr class="tabtd1">--%>
                <%--</c:if>--%>

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
            <td>职务：</td>
            <td><input type="text" name="postName" value="${postName}"/></td>
        </tr>
    </table>
</form>

<br><br><br>
<font color="#ff0000">
    <s:actionerror/>
</font>

</body>
<%--<script>--%>
<%--window.onload = function () {--%>
<%--$.post("depart", function (date) {--%>
<%--var _html = "";--%>

<%--for (var i = 0; i < date.length; i++) {--%>

<%--_html += "<option value='" + date[i].depID + "'>" + date[i].depName + "</option>"--%>

<%--}--%>

<%--$("#department").empty();--%>

<%--$("#department").append("<option value='-1'>--请选择--</option>");--%>

<%--$("#department").append(_html);--%>
<%--});--%>

<%--//        var xx = getUrlParam('depID');--%>

<%--$("#department").val("2c90906e5f5658e5015f565923d80000");--%>
<%--//--%>
<%--//        alert(xx)--%>
<%--}--%>
<%--//</script>--%>
</html>
