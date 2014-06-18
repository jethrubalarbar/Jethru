
<html>
<head>
<title></title>
</head>
<body>
<%
	WbdProductionHelper helper = null;
	JspHelper jh = null;
	String snippetVar_myProperty;
	String snippetVar_thisNavpoint;
%>
<!--START-->
<%@page import="tooltwist.wbd.WbdProductionHelper"%>
<%@page import="com.dinaa.data.XData"%>
<%@page import="tooltwist.jethru.productionHelpers.UserMaintenanceProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	//Get the production helper for this widget
	UserMaintenanceProductionHelper h = (UserMaintenanceProductionHelper) helper;
	XData data = h.getData(jh);
%>

		<script language="javascript">
		function addressChangeIt()
		{
		var i = 1;
		
			my_div.innerHTML = my_div.innerHTML 
		+ "<h3>Address</h3>"
		+ "<input style='margin-right: 5px;' type='text' name='streetNumber' id='streetNumber'  placeholder='Street Number' value='<%=h.getUserId() %>'>"
		+ "<input style='margin-right: 5px;' type='text' name='street' id='street'  placeholder='Street' value='<%=h.getUserId() %>'>"
		+ "<input type='text' name='barangay' id='barangay'  placeholder='Barangay' value='<%=h.getUserId() %>'></br>"
		+ "<input style='margin-right: 5px;' type='text' name='town' id='town'  placeholder='Town' value='<%=h.getUserId() %>'>"
		+ "<input type='text' name='province' id='province'  placeholder='Province' value='<%=h.getUserId() %>'></br>"
		+ "<input style='margin-right: 5px;' type='text' name='country' id='country'  placeholder='Country' value='Philippines'>"
		+ "<input type='text' name='zipCode' id='zipCode'  placeholder='Zip Code' value='<%=h.getUserId() %>'></br>";
				
		}
		
		function educationalChangeIt()
		{
		var e = 1;
		
			my_div2.innerHTML = my_div2.innerHTML 
		+ "<input style='margin-right: 5px;' type='text' name='school' id='school'  placeholder='School Name' value='<%=h.getUserId() %>'>"
		+ "<input style='margin-right: 5px;' type='text' name='schoolStart' id='schoolStart'  placeholder='School Year(Start)' value='<%=h.getUserId() %>'>"
		+ "<input type='text' name='schoolEnd' id='schoolEnd'  placeholder='School Year(End)' value='<%=h.getUserId() %>'></br>";
				
		}
		</script>
		
		<!-- ********** INSERT HTML HERE ********** -->
		
		<img src="http://www.twistresources.com/ttsvr/croppedWidgets/tr_images.tr_logo.png">



		<div id="userMaintenance">
		<h3>Student Information</h3>
		<form id="userForm" name="save" onsubmit="validateForm()" action="%%logout%%" method="POST">
		<input type="hidden" name="op" id="op" value="jethru_widgets.userMaintenance.updateUser">
		<input type="text" name="userId"  onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;" id="userId" placeholder="User ID" value="<%=h.getUserId() %>" disabled>
		<select id="courseID" style="width: 150px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;">
		<option value="bsit">BSIT</option>
  		<option value="bscs">BSCS</option>
  		<option value="bsnursing">BSNursing</option>
  		<option value="bsece">BSECE</option>
		</select>  
		<select name="year" id="yearID" style="width: 150px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;">
		<option value="firstYear">First Year</option>
  		<option value="secondYear">Second Year</option>
  		<option value="thirdYear">Third Year</option>
  		<option value="fourthYear">Fourth Year</option>
  		<option value="fifthYear">Fifth Year</option>
  		<option value="sixthYear">Sixth Year</option>
  		<option value="masteral">Masteral</option>
		</select><br>
		<input type="text" name="firstName" id="firstName"  placeholder="First Name" value="<%=h.getFirstName() %>">
		<input type="text" name="middleName" id="middleName"  placeholder="Middle Name" value="<%=h.getMiddleName() %>">
		<input type="text" name="lastName" id="lastName"  placeholder="Last Name" value="<%=h.getLastName() %>"><br>
		<input type="text" name="phoneNumber" id="phoneNumber"  placeholder="Phone Number" value="<%=h.getPhoneNumber() %>">
		<input type="text" name="homeNumber" id="homeNumber"  placeholder="Home Number" value="<%=h.getHomeNumber() %>"><br>
		<input type="text" name="email" id="email"  placeholder="Email Address" value="<%=h.getEmail() %>">
		<input type="text" name="reemail" id="reemail"  placeholder="Re-enter your Email Address" value="<%=h.getEmail() %>"><br>
		<input type="text" name="username"id="username" placeholder="Your Username" value="<%=h.getUsername() %>">
		<input type="password" name="password" id="password" placeholder="Your Preffered Password" value="<%=h.getPassword() %>">
		<input type="password" name="re-pass" id="re-pass" placeholder="Re-enter your Password" value="<%=h.getPassword() %>"><br>
		<span class="spanz">Active</span><input type="checkbox" name="status"  id="status"  <%if(h.getStatus().equals("1")){ out.print("checked");} %>/>
		
		<h3>Address</h3>
		<input type="text" name="streetNumber" id="streetNumber"  placeholder="Street Number" value="<%=h.getFirstName() %>">
		<input type="text" name="street" id="street"  placeholder="Street" value="<%=h.getMiddleName() %>">
		<input type="text" name="barangay" id="barangay"  placeholder="Barangay" value="<%=h.getLastName() %>"><br>
		<input type="text" name="town" id="town"  placeholder="City/Town" value="<%=h.getPhoneNumber() %>">
		<input type="text" name="province" id="province"  placeholder="Province" value="<%=h.getHomeNumber() %>"><br>
		<input type="text" name="country" id="country"  placeholder="Country" value="Philippines">
		<input type="text" name="zipCode" id="zipCode"  placeholder="Zip Code" value="<%=h.getEmail() %>"><br>
		<div id="my_div"></div>
		<input type="button" class="add_button" value="Add +" onClick="addressChangeIt()">
		

		<h3>Educational Background</h3>
		<input type="text" name="school" id="school"  placeholder="School Name" value="<%=h.getFirstName() %>">
		<input type="text" name="schoolStart" id="schoolStart"  placeholder="School Year(Start)" value="<%=h.getMiddleName() %>">
		<input type="text" name="schoolEnd" id="schoolEnd"  placeholder="School Year(End)" value="<%=h.getLastName() %>"><br>
		<div id="my_div2"></div>
		<input type="button"  class="add_button" value="Add +" onClick="educationalChangeIt()">
		
		<br><br><br>
		<div id="buttons">
		<input class="save_button" type="button" value="Save" id="save" />
		<a class="cancel_button" href=%%studentForm%%?userId=<%=h.getUserId() %>>Cancel</a>
		<a class="back_button" href=%%logout%%>Log Out</a>
		</div>
		</form>
		</div>

<!--END-->
</body>
</html>
