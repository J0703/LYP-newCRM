package com.lanou.refer.interceptor;

import com.lanou.hrd.domain.Crm_staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * Created by dllo on 17/10/28.
 */
public class ReferInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        Crm_staff staff = (Crm_staff) ServletActionContext.getRequest().getServletContext().getAttribute("staffOnePiece");
        if (!staff.getCrm_post().getCrm_department().getDepName().equals("咨询部")) {
            return "permissions";
        }
        return actionInvocation.invoke();
    }
}
