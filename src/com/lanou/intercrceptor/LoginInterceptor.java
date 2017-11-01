package com.lanou.intercrceptor;

import com.lanou.hrd.domain.Crm_staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;

/**
 * Created by dllo on 17/10/31.
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        ServletContext servletContext = ServletActionContext.getServletContext();

        Crm_staff staffOnePiece = (Crm_staff) servletContext.getAttribute("staffOnePiece");

        if (staffOnePiece == null) {

            return "login";

        } else {

            return actionInvocation.invoke();

        }

    }
}
