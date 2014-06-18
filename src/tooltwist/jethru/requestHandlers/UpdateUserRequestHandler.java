package tooltwist.jethru.requestHandlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.dinaa.data.XData;
import com.dinaa.ui.UiModuleException;
import com.dinaa.ui.UimHelper;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcException;

import tooltwist.wbd.WbdRequestHandler;

/**
 * Request handler "updateUser" - Handler to Update User
 * 
 * This handler can be called from a client browser before control is passed to a normal
 * navpoint. To call it, add this parameter to a normal ToolTwist URL:
 * 
 *         op=jethru_widgets.userMaintenance.updateUser
 * 
 * After this method is called, the requested navpoint will be displayed in the usual
 * manner. To pass control to a different navpoint, use RoutingUIM.gotoNavpoint(), and
 * then return true.
 *
 * @author ?
 */
public class UpdateUserRequestHandler extends WbdRequestHandler
{

	@Override
	public boolean handler(UimHelper uh, String widgetId, String method) throws UiModuleException, ServletException, IOException, XpcException
	{
		try {
		
		HttpServletRequest request = uh.getRequest();
		
		String userId = request.getParameter("userId");
		String fullname = request.getParameter("fullName");
		String year = request.getParameter("year");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String middleName = request.getParameter("middleName");
		String phoneNumber = request.getParameter("phoneNumber");
		String homeNumber = request.getParameter("homeNumber");
		String email = request.getParameter("email");
		String reemail = request.getParameter("reemail");
		String status = request.getParameter("status");
		
		Xpc xpc = uh.getXpc();
		if(userId == null || userId.equals("")){
			xpc.start("phinza.D.user", "insert");
			uh.reply("New user succefully added");	
		}else{
			xpc.start("phinza.D.user", "update");
			xpc.attrib("userId", userId);
			uh.reply("New user succefully updated");	
		}
		xpc.attrib("fullName", fullname);
		xpc.attrib("firstName", firstName); 
		xpc.attrib("year", year);
		xpc.attrib("lastName", lastName);
		xpc.attrib("middleName", middleName);
		xpc.attrib("email", email);
		xpc.attrib("reemail", reemail);
		xpc.attrib("phoneNumber", phoneNumber);
		xpc.attrib("homeNumber", homeNumber);
		xpc.attrib("username", username);
		xpc.attrib("password", password);
		
	
		if (status==null || status.equals("") || status.equals("false")){
			xpc.attrib("status", "0");
		}else{
			xpc.attrib("status", "1");
		}
		xpc.attrib("status", status);
		xpc.run();
		}catch (Exception e){
			System.out.print("Error occured");
		}
		return true;
	}

}
