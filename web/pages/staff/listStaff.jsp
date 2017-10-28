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

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img
                    src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工注入 --%>
            <a href="${pageContext.request.contextPath}/pages/staff/addStaff.jsp">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/findAll.action" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">

                <select name="department" id="department">
                    <option value="-1">--请选择部门--</option>
                    <%--<option value="ee050687bd1a4455a153d7bbb7000001">教学部</option>--%>
                    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
                </select>

            </td>
            <td width="80px">职务：</td>
            <td width="200px">

                <select name="post" id="post">
                    <option value="-1">--请选择职务--</option>
                    <%--<option value="ee050687bd1a4455a153d7bbb7000003">总监</option>--%>
                    <%--<option value="ee050687bd1a4455a153d7bbb7000004">讲师</option>--%>
                    <%--<option value="ee050687bd1a4455a153d7bbb7000005">主管</option>--%>
                </select>

            </td>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" size="12"/></td>
            <%--<td> <input type="submit" value="提交"></td>--%>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>


    <%--<td align="center">赵六</td>--%>
    <%--<td align="center">男</td>--%>
    <%--<td align="center">2012-02-12</td>--%>
    <%--<td align="center">咨询部</td>--%>
    <%--<td align="center">主管</td>--%>

    <c:forEach items="${pd.beanList}" var="staff" varStatus="a">
    <c:if test="${a.index%2==0}">
    <tr class="tabtd1">
        </c:if>
        <c:if test="${a.index%2!=0}">
    <tr class="tabtd2">
        </c:if>

        <td align="center">${staff.staffName}</td>
        <td align="center">${staff.gender}</td>
        <td align="center">${staff.onDutyDate}</td>
        <td align="center">${staff.crm_post.crm_department.depName}</td>
        <td align="center">${staff.crm_post.postName}</td>
        <td width="7%" align="center">

            <%--staffId=${staff.staffId}--%>
            <%--postID=${staff.crm_post.postId}--%>
            <%--depID=${staff.crm_post.crm_department.depID}--%>

            <a href="${pageContext.request.contextPath}/IdStaff.action?staffId=${staff.staffId}&pid=${staff.crm_post.postId}&depID=${staff.crm_post.crm_department.depID}"><img
                    src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
      </td>
   </c:forEach>


    <%--<tr class="tabtd1">--%>
        <%--<td align="center">管理员</td>--%>
        <%--<td align="center"></td>--%>
        <%--<td align="center"></td>--%>
        <%--<td align="center"></td>--%>
        <%--<td align="center"></td>--%>
        <%--<td width="7%" align="center">--%>

            <%--<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img--%>
                    <%--src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
        <%--</td>--%>

    <%--</tr>--%>


    <%--<tr class="tabtd2">--%>
    <%--<td align="center">赵六</td>--%>
    <%--<td align="center">男</td>--%>
    <%--<td align="center">2012-02-12</td>--%>
    <%--<td align="center">咨询部</td>--%>
    <%--<td align="center">主管</td>--%>

    <%--<td width="7%" align="center">--%>
    <%--<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img--%>
    <%--src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
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
</body>
<script>
    window.onload = function () {
        $.post("depart", function (date) {
            var _html = "";

            for (var i = 0; i < date.length; i++) {

                _html += "<option value='" + date[i].depID + "'>" + date[i].depName + "</option>"

            }

            $("#department").empty();

            $("#department").append("<option value='-1'>--请选择部门--</option>");

            $("#department").append(_html);
        });

        $.post("", function () {

        });



        $("#department").change(function () {

            $("#post").empty();

            $("#post").append("<option value='-1'>--请选择职务--</option>");

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
