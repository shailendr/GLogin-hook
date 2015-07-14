package com.shail.factory;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class EmailAddress implements IUser {

	public User isUser(String emailAddress) {
		User user = null;
		try {
			user = UserLocalServiceUtil.fetchUserByEmailAddress(IConstant.companyId, emailAddress);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return user;
		
	}

}
