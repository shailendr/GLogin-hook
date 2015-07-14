package com.shail.liferay.hook.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.shail.Util.UserAddUtil;
import com.shail.factory.UserValidatorFactory;

public class ExampleStrutsPortletAction extends BaseStrutsPortletAction{
    
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
		
		if(ParamUtil.getBoolean(actionRequest, "addUser")){
			System.out.println("Inside If method");
			UserAddUtil.userProcessAction(actionRequest);
			actionResponse.setRenderParameter("jspPage", "/html/portlet/login_password_step.jsp");
			//actionResponse.sendRedirect("/html/portlet/login_password_step.jsp");
		}else if(ParamUtil.getBoolean(actionRequest, "passwordValidation")){
			
		}

      //  originalStrutsPortletAction.processAction(originalStrutsPortletAction, portletConfig, actionRequest,actionResponse);
    }

    public String render(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws Exception {

        return originalStrutsPortletAction.render( null, portletConfig, renderRequest, renderResponse);

    }

    public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {

        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }
	
}
