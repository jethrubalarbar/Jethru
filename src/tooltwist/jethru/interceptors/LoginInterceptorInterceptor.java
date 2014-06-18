package tooltwist.jethru.interceptors;

import java.io.IOException;

import javax.servlet.ServletException;

import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;

import tooltwist.ecommerce.WbdInterceptor;
import tooltwist.wbd.WbdSession;

/*
 * Interceptor loginInterceptor - Login Interceptor.
 * 
 * This class intercepts a request sent to a ToolTwist generated site. Interceptors
 * are called before any other processing, and allow a chance to perform site-wide
 * operations - for example, login redirection, passing parameters from page to page
 * by automatically appending them to URLs, or detecting the browser device.  
 */
public class LoginInterceptorInterceptor extends WbdInterceptor
{

	@Override
	public boolean intercept(UimHelper uh, String navpoint) throws UiModuleException, ServletException, IOException
	{
		
		
// Uncomment this to implement an automatic parameter
//		/*
//		 * Set up an automatic variable:
//		 * 1. See if the "op" parameter is specifying a new value.
//		 * 2. Otherwise, try to propagate the existing automatic parameter.
//		 */
//		String AUTOMATIC_PARAMETER_NAME = "acct";
//		String op = uh.getRequestValue("op");
//		if (op != null && op.equals("showAccount"))
//		{
//			// Set a new or initial value for the automatic parameter.
//			String newValue = uh.getRequestValue("newAcct");
//			WbdSession.setAutomaticUrlParameter(uh.getCredentials(), AUTOMATIC_PARAMETER_NAME, newValue);
//		}
//		else
//		{
//			// Take the existing automatic parameter, and pass it on through.
//			String existingParameterValue = uh.getRequestValue(AUTOMATIC_PARAMETER_NAME);
//			if (existingParameterValue != null)
//				WbdSession.setAutomaticUrlParameter(uh.getCredentials(), AUTOMATIC_PARAMETER_NAME, existingParameterValue);
//		}


// Uncomment this to redirect to a different navpoint
//		// Perhaps redirect to a different page
//		if (CHECK SOMETHING HERE)
//		{
//			String alternateNavpoint = "[[string-shortProjectName]]-home";
//			RoutingUIM.gotoNavpoint(uh, alternateNavpoint);
//			return true; // redirected already
//		}
		return false;
	}

}
