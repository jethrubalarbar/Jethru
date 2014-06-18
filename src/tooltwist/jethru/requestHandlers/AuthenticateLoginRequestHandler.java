package tooltwist.jethru.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.data.XData;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "authenticateLogin" - Authentication of Credentials of Students
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=jethru_widgets.login.authenticateLogin
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class AuthenticateLoginRequestHandler extends WbdRequestHandler
{


	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException
	{
		try {
			
			HttpServletRequest request = uh.getRequest();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String result = "";
			
			Xpc xpc = uh.getXpc();
			
			xpc.start("phinza.D.user", "select");
			XData data = xpc.run();
			XNodes nodes = data.getNodes("/select/user");
			xpc.attrib("username", username);
			xpc.attrib("password", password);
	
			
		   for(nodes.first(); nodes.next(); ) {
				if(username.equals(nodes.getText("username"))&&password.equals(nodes.getText("password"))){	
					result = nodes.getText("userId");
					break;
				}else{
					result="Bro, wrong password or username!";
				}
				
		   }
		uh.reply(result);
			
			}catch (Exception e){
				System.out.print("Error occured!");
			}
			return true;
	}

}
