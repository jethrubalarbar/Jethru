
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
<%@page import="tooltwist.jethru.productionHelpers.LoginProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%@page import="com.dinaa.data.XNodes"%>
<%
	// Get the production helper for this widget
	LoginProductionHelper h = (LoginProductionHelper) helper;
	XData data = h.getData(jh);
	XNodes nodes = data.getNodes("/select/user");
%>


<!-- ********** INSERT HTML HERE ********** -->

<div class="loginForm">
	<h1>Students Login</h1>
	<p>Login your credentials and apply courses.</p>

	<form id="studentLogin" name="studentLogin" action="%%toHome%%?userId=" method="POST">
	<input type="hidden" name="op" id="op" value="jethru_widgets.login.authenticateLogin">
	<input type="text" name="usernameField" id="usernameFieldID" value="" placeholder="Username">
	<input type="password" name="passwordField" id="passwordFieldID" value="" placeholder="Password">
	<br>
	<input type="button" name="submitButton" id ="submitButtonID" value="LOGIN">
	<a id ="cancelButtonID" href="%%cancel%%">CANCEL</a>
	</form>
	

	
	
	
</div>
<!--END-->
</body>
</html>
