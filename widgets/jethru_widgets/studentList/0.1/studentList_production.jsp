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
<%@page import="tooltwist.jethru.productionHelpers.StudentListProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	StudentListProductionHelper h = (StudentListProductionHelper) helper;
	XData data = h.getData(jh);
%>

<!-- ********** INSERT HTML HERE ********** -->
<table>
	<tr>
			<th width="10%">ID</th>
			<th width="30%">First Name</th>
			<th width="30%">Middle Name</th>
			<th width="30%">Last Name</th>
	</tr>
	<tr>
			<td>2</td>
			<td>Lebron</td>
			<td>Raymone</td>
			<td>James</td>
	</tr>
</table>
<!--END-->
</body>
</html>
