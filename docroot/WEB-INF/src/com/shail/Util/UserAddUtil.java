package com.shail.Util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.shail.factory.UserValidatorFactory;

public class UserAddUtil {
	public static void userProcessAction(ActionRequest actionRequest){
        User user = UserValidatorFactory.getUser(ParamUtil.getString(actionRequest, "login"), 
			ParamUtil.getString(actionRequest, "authType"));

		if(Validator.isNotNull(user)){
		// User Will go step forwards.
		}
	}
}
