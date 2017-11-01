package com.lanou.intercrceptor;

import com.lanou.hrd.domain.Crm_staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;

/**
 * Created by dllo on 17/10/31.
 */
public class AddAndUpdateInterceptor extends MethodFilterInterceptor {

    private static final String hrId = "2c90906e5f56cd78015f56ced39e0002";

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        ServletContext servletContext = ServletActionContext.getServletContext();

        Crm_staff staffOnePiece = (Crm_staff) servletContext.getAttribute("staffOnePiece");

        String depID = staffOnePiece.getCrm_post().getCrm_department().getDepID();

        if (!depID.equals(hrId)) {

            servletContext.setAttribute("msg", "麻烦认清楚你的权限");
            return "error";

        } else {

            return actionInvocation.invoke();

        }

    }
}
