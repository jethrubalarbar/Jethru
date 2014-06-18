package tooltwist.jethru.productionHelpers;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.commons.httpclient.methods.PostMethod;

import tooltwist.ecommerce.AutomaticUrlParametersMode;
import tooltwist.ecommerce.RoutingUIM;
import tooltwist.misc.JspHelper;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.wbd.WbdSession;

import com.dinaa.data.XData;
import com.dinaa.data.XNodes;
import com.dinaa.ui.UimData;
import com.dinaa.xpc.Xpc;
import com.dinaa.xpc.XpcSecurity;

public class UserMaintenanceProductionHelper extends WbdProductionHelper
{
	private String userId;
	private String fullName;
	private String year;
	private String username;
	private String status;
	private String password;
	private String phoneNumber;
	private String homeNumber;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String reemail;
	
	public UserMaintenanceProductionHelper(Properties prop)
	{
		super(prop);
	}

	@Override
	public XData preFetch(UimData ud) throws Exception
	{
		
		HttpServletRequest request = ((JspHelper)ud).getRequest();
		String userId = request.getParameter("userId");
		
		Xpc xpc = ud.getXpc();
		xpc.start("phinza.D.user", "select");
        xpc.attrib("userId", userId);
        XData data = xpc.run();
        
        XNodes nodes = data.getNodes("/select/user");
        nodes.next();
        
        setUserId(nodes.getText("userId"));
        setUsername(nodes.getText("username"));
        setFullName(nodes.getText("fullName"));
        setYear(nodes.getText("year"));
        setFirstName(nodes.getText("firstName"));
        setMiddleName(nodes.getText("middleName"));
        setLastName(nodes.getText("lastName"));
        setEmail(nodes.getText("email"));
        setReEmail(nodes.getText("reemail"));
        setPhoneNumber(nodes.getText("phoneNumber"));
        setHomeNumber(nodes.getText("homeNumber"));
        setStatus(nodes.getText("status"));
        setPassword(nodes.getText("password"));
        
        return null;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getReEmail() {
		return reemail;
	}

	public void setReEmail(String reemail) {
		this.reemail = reemail;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
