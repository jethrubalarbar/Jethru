
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
<%@page import="tooltwist.jethru.productionHelpers.UserListProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%@page import="com.dinaa.data.XNodes"%>
<%
	// Get the production helper for this widget
	UserListProductionHelper h = (UserListProductionHelper) helper;
	XData data = h.getData(jh);
	XNodes nodes = data.getNodes("/select/user");
%>

<!-- ********** INSERT HTML HERE ********** -->
<table style="width:950px">
<tr>
  <th>ID</th>
  <th>Username</th>
  <th>First Name</th>		
  <th>Status</th>
  <th>Action</th>
</tr>

<% for(nodes.first(); nodes.next(); ) {%>
<tr>
	<td><%=nodes.getText("userId") %></td>
	<td><%=nodes.getText("username") %></td>
	<td><%=nodes.getText("firstName") %></td>
	<td>
	<%if(nodes.getText("status").equals("1")){ %>
		<img src = "http://static.tumblr.com/jscxg5p/n2um9hwd8/check.png"/>
	<%} %>
	<td><a href="%%navpoint%%?userId=<%=nodes.getText("userId") %>">Edit</a></td>
</tr>

<%} %>
</table>
<a href="%%navpoint%%">Add User</a>



<!--END-->
</body>
</html>
