<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <STYLE>
        .cla1 {
            FONT-SIZE: 12px;
            COLOR: #4b4b4b;
            LINE-HEIGHT: 18px;
            TEXT-DECORATION: none
        }

        .login_msg {
            font-family: serif;
        }

        .login_msg .msg {
            background-color: #acf;
        }

        .login_msg .btn {
            background-color: #9be;
            width: 73px;
            font-size: 18px;
            font-family: 微软雅黑;
        }
        a{text-decoration: none}
        div>a:hover{
            font-size: xx-large;
            color: red;
        }
        a:visited{
            color: blue;
        }
    </STYLE>

    <TITLE></TITLE>
    <script type="text/javascript">
        if (self != top) {
            top.location = self.location;
        }
    </script>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <LINK href="${pageContext.request.contextPath}/css/style.css" type=text/css rel=stylesheet>
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>
</HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
      background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
        <tr>
            <td height="193"></td>

        </tr>
        <tr align="center">

            <td class="login_msg" width="400">
                <form action="login.action" method="post">

                    <font size="6" color="#ffffff">
                        欢迎使用CRM系统
                    </font>
                    <br/>
                    <br/>
                    <font color="#ff0000">
                        <s:actionerror/>
                    </font>
                    <br/>
                    用户名：<input type="text" name="loginName" class="msg" placeholder="请输入用户名"
                               onfocus="if(placeholder=='请输入用户名') {value=''}" onblur="if (value=='')
        {value='请输入用户名'}" maxlength="30"/><br/><br/>
                    密&nbsp;码：<input type="password" name="loginPwd" class="msg" placeholder="请输入密码"  maxlength="15"/><br/><br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="submit" class="btn" value="登录 "/>

                </form>
            </td>
        </tr>
    </table>

    <a href="/小游戏.jsp">不如打把游戏??</a>

    <%--<div class="login-form">--%>
        <%--<div class="close"> </div>--%>
        <%--<div class="head-info">--%>
            <%--<label class="lbl-1"> </label>--%>
            <%--<label class="lbl-2"> </label>--%>
            <%--<label class="lbl-3"> </label>--%>
        <%--</div>--%>
        <%--<div class="clear"> </div>--%>
        <%--<form action="/home" method="post">--%>
            <%--<input type="text" class="text" name="username" id="username">--%>
            <%--<div class="key">--%>
                <%--<input type="password" name="password" id="password">--%>
            <%--</div>--%>

            <%--<div>--%>
                <%--&lt;%&ndash;<label>完成验证：</label>&ndash;%&gt;--%>
                <%--<div id="captcha1">--%>
                    <%--<p id="wait1" class="show">正在加载验证码......</p>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<br><br>--%>

            <%--<p id="notice1" class="hide">请先完成验证</p>--%>

            <%--<div class="signin">--%>
                <%--<input type="submit" class="btn" id="submit1"  value="Login">--%>
            <%--</div>--%>
        <%--</form>--%>

    <%--</div>--%>

    <script type="text/javascript">

        var handler1 = function (captchaObj) {
            $("#submit1").click(function (e) {
                var result = captchaObj.getValidate();
                if (!result) {
                    $("#notice1").show();
                    setTimeout(function () {
                        $("#notice1").hide();
                    }, 2000);
                    e.preventDefault();
                }
            });
            // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
            captchaObj.appendTo("#captcha1");
            captchaObj.onReady(function () {
                $("#wait1").hide();
            });
            // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
        };
        $.ajax({
            url: "/startCaptcha?t=" + (new Date()).getTime(), // 加随机数防止缓存
            type: "get",
            dataType: "json",
            success: function (data) {
                // 调用 initGeetest 初始化参数
                // 参数1：配置参数
                // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
                initGeetest({
                    gt: data.gt,
                    challenge: data.challenge,
                    new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                    offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                    product: "float", // 产品形式，包括：float，popup
                    width: "100%"
                    // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
                }, handler1);
            }
        });


        <%--/* s标签中直接编写JavaScript代码时，不支持el表达式，只能提供单独的函数--%>
         <%--function registerUrl(){--%>
         <%--document.location='${pageContext.request.contextPath}/uiAction_staff_register';--%>
         <%--}--%>
         <%--*/--%>
    </script>
</div>
</BODY>
</HTML>