package com.shail.factory;

import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.User;

public class UserValidatorFactory {

	public static User getUser(String value, String authType){
		
		if (authType.equalsIgnoreCase(CompanyConstants.AUTH_TYPE_EA)) {
			return new EmailAddress().isUser(value);
		}
		else if (authType.equalsIgnoreCase(CompanyConstants.AUTH_TYPE_SN)) {
			return new ScreenName().isUser(value);
		}
		else if (authType.equalsIgnoreCase(CompanyConstants.AUTH_TYPE_ID)) {
			return new ID().isUser(value);
		}
		
		return null;
	}
}
