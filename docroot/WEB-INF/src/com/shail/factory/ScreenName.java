package com.shail.factory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ScreenName implements IUser {

	public User isUser(String screenName) {
		User user = null;
		try {
			user = UserLocalServiceUtil.fetchUserByScreenName(IConstant.companyId, screenName);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return user;		
	}

}
