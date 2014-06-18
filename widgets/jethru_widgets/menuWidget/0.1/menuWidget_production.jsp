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
<%--
<%@page import="tooltwist.jethru.productionHelpers.MenuWidgetProductionHelper"%>
--%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
//	MenuWidgetProductionHelper h = (MenuWidgetProductionHelper) helper;
//	XData data = h.getData(jh);
%>

<div id='cssmenu'>
<ul>
   <li class=''><a href='index.html'><span>Home</span></a></li>
   <li class='active'><a href='#'><span>Products</span></a></li>
   <li><a href='#'><span>About</span></a></li>
   <li class='last'><a href='#'><span>Contact</span></a></li>
</ul>
</div>

<!--END-->
</body>
</html>


