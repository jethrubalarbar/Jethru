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
<%@page import="tooltwist.jethru.productionHelpers.FormWidgetProductionHelper"%>
<%@page import="tooltwist.misc.JspHelper"%>
<%@page import="tooltwist.ecommerce.AutomaticUrlParametersMode"%>
<%@page import="tooltwist.ecommerce.RoutingUIM"%>
<%
	// Get the production helper for this widget
	FormWidgetProductionHelper h = (FormWidgetProductionHelper) helper;
	XData data = h.getData(jh);
%>


<script>
function validateForm() {
    var id = document.forms["myForm"]["idNumber"].value;
    var fname = document.forms["myForm"]["firstName"].value;
    var mname = document.forms["myForm"]["middleName"].value;
    var lname = document.forms["myForm"]["lastName"].value;
    var email = document.forms["myForm"]["email"].value;
    var reemail = document.forms["myForm"]["reemail"].value;
    var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
    
    if( email !== reemail){
    	alert( "Please check if Emails are the same!" );
        document.myForm.reemail.focus() ;
        return false;  	
    }
    if( id == "" )
    {
      alert( "Please provide your ID NUMBER!" );
      document.myForm.idNumber.focus() ;
      return false;
    }
    
    if( fname == "" )
    {
        alert( "Please provide your FIRST NAME!" );
        document.myForm.firstName.focus() ;
        return false;
      }
    if( mname == "" )
    {
        alert( "Please provide your MIDDLE NAME!" );
        document.myForm.middleName.focus() ;
        return false;
      }
    if( lname == "" )
    {
        alert( "Please provide your LAST NAME!" );
        document.myForm.lastName.focus() ;
        return false;
      }

    for (var i = 0; i < document.myForm.firstName.value.length; i++) {
        if (iChars.indexOf(document.myForm.firstName.value.charAt(i)) != -1) {
        alert ("FIrst Name Field has special characters. \nSpecial Characters are not allowed");
        return false;
            }
        }
    for (var i = 0; i < document.myForm.middleName.value.length; i++) {
        if (iChars.indexOf(document.myForm.middleName.value.charAt(i)) != -1) {
        alert ("FIrst Name Field has special characters. \nSpecial Characters are not allowed");
        return false;
            }
        }
    for (var i = 0; i < document.myForm.lastName.value.length; i++) {
        if (iChars.indexOf(document.myForm.lastName.value.charAt(i)) != -1) {
        alert ("FIrst Name Field has special characters. \nSpecial Characters are not allowed");
        return false;
            }
        }
    for (var i = 0; i < document.myForm.idNumber.value.length; i++) {
        if (iChars.indexOf(document.myForm.idNumber.value.charAt(i)) != -1) {
        alert ("FIrst Name Field has special characters. \nSpecial Characters are not allowed");
        return false;
            }
        }
    }

</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	  $("#flip").click(function(){
	    $("#panel").slideToggle("slow");
	  });
	});

$(document).ready(function(){
	  $("#flip1").click(function(){
	    $("#panel1").slideToggle("slow");
	  });
	});
</script>
 <style>

 .bg-bg{
 		background: #F8F7F7;
 }
 .inputFields{

 }
 
	
 }
 </style>
 
<style> 
#panel,#flip,#panel1,#flip1
{
padding:5px;
text-align:center;
background-color:#gray	;
border:solid 1px #c3c3c3;

}
#panel, #panel1
{
padding:50px;
display:none;
}
#flip{
font-family: 'Freight Sans', 'lucida grande',tahoma,verdana,arial,sans-serif;	font-size: 19px;
}
#flip1{
margin-top: 20px;
font-family: 'Freight Sans', 'lucida grande',tahoma,verdana,arial,sans-serif;	font-size: 19px;
}
</style>


<!-- ********** INSERT HTML HERE ********** -->


<div id='form'>
	<div class="form_table">
		<h1 style="font-size: 36px;
		font-family: 'Freight Sans Bold', 'lucida grande',tahoma,verdana,arial,sans-serif;
		margin-bottom: -15px">Create Data</h1>
		<p style="font-family: 'Freight Sans', 'lucida grande',tahoma,verdana,arial,sans-serif;	font-size: 19px;">It's free and always will be.</p>		
		<form name="myForm"  onsubmit="return validateForm();" method="post">
		<input class="inputField" onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;" type="text" name="idNumber" placeholder="ID Number" style="width: 200px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" >
		<select style="width: 150px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;">
		<option value="bsit">BSIT</option>
  		<option value="bscs">BSCS</option>
  		<option value="bsnursing">BSNursing</option>
  		<option value="bsece">BSECE</option>
		</select>  
		<select style="width: 150px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;">
		<option value="firstYear">First Year</option>
  		<option value="secondYear">Second Year</option>
  		<option value="thirdYear">Third Year</option>
  		<option value="fourthYear">Fourth Year</option>
  		<option value="fifthYear">Fifth Year</option>
  		<option value="sixthYear">Sixth Year</option>
  		<option value="masteral">Masteral</option>
		</select></br>
		
		<input class="inputField"  type="text" name="firstName" placeholder="First Name" style="width: 150px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" >
		<input class="inputField"  type="text" name="middleName" placeholder="Middle Name" style="width: 150px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" >
		<input class="inputField"  type="text" name="lastName" placeholder="Last Name" style="width: 200px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
		<input class="inputField"  type="text" name="pNumber" placeholder="Phone Number" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>		
		<input class="inputField"  type="text" name="email" placeholder="Email Address" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
		<input class="inputField"  type="text" name="reemail" placeholder="Re-Enter Email Address" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
		<input class="inputField"  type="password" name="password" placeholder="Password" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
		
		
<div id="flip">Add Address</div>
<div id="panel">
<input class="inputField"  type="text" name="hNumber" placeholder="Home Number" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="street" placeholder="Street" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="brgy" placeholder="Barangay" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="towncity" placeholder="Town/City" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="province" placeholder="Province" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="country" placeholder="Country" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="zCode" placeholder="Zip Code" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input id="flip" type="button" value="Add My Address" style="background: -webkit-linear-gradient(#67ae55, #578843); -webkit-box-shadow: inset 0 1px 1px #a4e388; font-size: 19px; font-family: 'Freight Sans Bold', 'lucida grande',tahoma,verdana,arial,sans-serif !important; text-rendering: optimizelegibility; min-width: 194px;padding: 7px 20px;text-align: center;border: 1px solid;-webkit-border-radius: 5px;color: #fff;cursor: pointer;display: inline-block;letter-spacing: 1px;position: relative;text-shadow: 0 1px 2px rgba(0,0,0,.5);">
</div>

<div id="flip1">Add Educational Background</div>
<div id="panel1">
<input class="inputField"  type="text" name="eSchool" placeholder="Elementary School" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="eSY" placeholder="School Year" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="sSchool" placeholder="Secondary School" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input class="inputField"  type="text" name="sSY" placeholder="School Year" style="width: 	508px; padding: 10px; border-radius: 7px; font-size: 15px; margin-bottom:15px;" ><br>
<input type="button" value="Add Educational Background" style="background: -webkit-linear-gradient(#67ae55, #578843); -webkit-box-shadow: inset 0 1px 1px #a4e388; font-size: 19px; font-family: 'Freight Sans Bold', 'lucida grande',tahoma,verdana,arial,sans-serif !important; text-rendering: optimizelegibility; min-width: 194px;padding: 7px 20px;margin-bottom: 15px;text-align: center;border: 1px solid;-webkit-border-radius: 5px;color: #fff;cursor: pointer;display: inline-block;letter-spacing: 1px;position: relative;text-shadow: 0 1px 2px rgba(0,0,0,.5);"></br>		
</div>
		
		
		<input style="margin-top: 20px; "class="inputField" type="radio" name="sex" value="male"><label style="color: #333;font-size: 18px;font-weight: normal;line-height: 18px;padding: 0 10px 0 3px; font-family: 'lucida grande',tahoma,verdana,arial,sans-serif;">Male<label>
		<input class="inputField" type="radio" name="sex" value="female"><label style="color: #333;font-size: 18px;font-weight: normal;line-height: 18px;padding: 0 10px 0 3px; font-family: 'lucida grande',tahoma,verdana,arial,sans-serif;">Female<label>
		<pre style= "font-size: 13px;">By clicking Save, your Data will be inserted to the Database student.</pre>
		<input type="submit" value="Save" style="background: -webkit-linear-gradient(#67ae55, #578843); -webkit-box-shadow: inset 0 1px 1px #a4e388; font-size: 19px; font-family: 'Freight Sans Bold', 'lucida grande',tahoma,verdana,arial,sans-serif !important; text-rendering: optimizelegibility; min-width: 194px;
padding: 7px 20px;text-align: center;border: 1px solid;-webkit-border-radius: 5px;color: #fff;cursor: pointer;display: inline-block;letter-spacing: 1px;position: relative;text-shadow: 0 1px 2px rgba(0,0,0,.5);">
		</form>
		
		
	</div>
</div>

<!--END-->
</body>
</html>
