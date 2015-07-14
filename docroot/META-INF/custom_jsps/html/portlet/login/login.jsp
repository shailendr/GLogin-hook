<%@ include file="/html/portlet/login/init.jsp" %>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<p>Your Welcome in our portal</p>
	</c:when>
	<c:otherwise>
		<div class="signin-cart card">
			<div class="circle-mask" style=" ">
				<canvas id="canvas" class="circle" width="96" height="96"></canvas>
			</div>
			<%
				String redirect = ParamUtil.getString(request, "redirect");
		
				String login = LoginUtil.getLogin(request, "login", company);
				String password = StringPool.BLANK;
				boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");
		
				if (Validator.isNull(authType)) {
					authType = company.getAuthType();
				}
			%>
			<portlet:actionURL secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL" >
				<portlet:param name="struts_action" value="/login/login" />
			</portlet:actionURL>
			
			<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="fm">
				
				<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
				<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
				<aui:input name="authType" type="hidden" value="<%= authType %>" />
				<aui:input name="addUser" type="hidden" value="<%= true %>" />
				<aui:fieldset>

				<%
					String loginLabel = null;
	
					if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
						loginLabel = "email-address";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						loginLabel = "screen-name";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
						loginLabel = "id";
					}
				%>
				
					<aui:input  autoFocus="<%= windowState.equals(LiferayWindowState.EXCLUSIVE) || windowState.equals(WindowState.MAXIMIZED) %>" placeholder="Please Enter Your <%= loginLabel %>" cssClass="clearable Email" label="" name="login" showRequiredLabel="<%= false %>" type="text" >
						<aui:validator name="required" />
					</aui:input>
					<aui:button-row>
						<aui:button type="submit" value="next" cssClass="rc-button" />
					</aui:button-row>
					
					<aui:a class="need-help" href="#"> Need help? </aui:a>
				</aui:fieldset>

			</aui:form>
		</div>
	</c:otherwise>
</c:choose>
<style>
.signin-cart{
	height: 400px;
}
.signin-card {
    overflow: hidden;
    position: relative;
}
.signin-card {
    padding: 40px;
    width: 274px;
}
.card {
    background-color: #f7f7f7;
    border-radius: 2px;
    box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
    margin: 0 auto 25px;
    padding: 20px 25px 30px;
    width: 304px;
}
.circle {
    background-position: center center;
    background-repeat: no-repeat;
    border-radius: 50%;
    height: 96px;
    opacity: 0.99;
    overflow: hidden;
    position: absolute;
    width: 96px;
    z-index: 101;
}
#canvas {
    opacity: 0.01;
    transition: opacity 0.075s ease 0s;
}

.circle-mask {
    background-image: url("https://ssl.gstatic.com/accounts/ui/avatar_2x.png");
    background-repeat: no-repeat;
    background-size: 96px auto;
    border-radius: 50%;
    display: block;
    height: 96px;
    margin-bottom: 10px;
    margin-left: auto;
    margin-right: auto;
    overflow: hidden;
    transition: opacity 0.075s ease 0s;
    width: 96px;
    z-index: 100;
}
.rc-button{
	box-sizing: border-box;
    display: block;
    margin-bottom: 10px;
    position: relative;
    width: 100%;
    z-index: 1;
    height: 46px;
}
.aui input {
    width: 100% !important;
}
.aui input[type="text"]{
	height: 46px;
}
.signin-card .Email {
    margin-top: 16px;
}
.signin-card .Email {
    margin-bottom: 0;
}
.signin-card .Email {
    direction: ltr;
    font-size: 16px;
    height: 44px;
}
.Email {
    box-sizing: border-box;
    display: block;
    margin-bottom: 10px;
    position: relative;
    width: 100%;
    z-index: 1;
}
</style>