
var UserMaintenance = function() {
	return {
		myVariable: null,

		init: function() {
			

			jQuery("#save").click(
					function() {
						
						var op = $("#op").val();
						var userId = $("#userId").val();
						var fullName = $("#fullName").val();
						var firstName = $("#firstName").val();
						var lastName = $("#lastName").val();
						var middleName = $("#middleName").val();
						var email = $("#email").val();
						var reemail = $("#reemail").val();
						var phoneNumber = $("#phoneNumber").val();
						var homeNumber = $("#homeNumber").val();
						var username = $("#username").val();
						var password = $("#password").val();
						var status = $("#status").attr("checked");
						var repass = $("#re-pass").val();
						var e = document.getElementById("yearID");
						var year = e.options[e.selectedIndex].text;
						var isValid = true;
						var msg = "";
						
						if(firstName ==""){
							msg += "First Name is required!\n";
							isValid = false;
						}if(lastName ==""){
							msg += "Last Name is required!\n";
							isValid = false;
						}if(middleName ==""){
							msg += "Middle Name is required!\n";
							isValid = false;
						}if(phoneNumber =="" && homeNumber==""){
							msg += "Input atleast one Contact Information\n";
							isValid = false;
						}if(username ==""){
							msg += "Username is required!\n";
							isValid = false;
						}if(password ==""){
							msg += "Password is required!\n";
							isValid = false;
						}if(reemail != email){
							msg += "Email not matched!\n";
							isValid = false;
						}if(phoneNumber.length != 11){
							msg += "(11) Eleven digits Only!\n";
							isValid = false;
						}if(homeNumber.length != 7){
							msg += "(7) Seven digits Only!\n";
							isValid = false;
						}if(password != repass){
							msg += "Password not mathced\n";
							isValid = false;
						}else if(password.length <=7){
							msg += "Password needs to be 8 characters or above!	";
							isValid = false;
						}
						
						if (!isValid){
							alert(msg);
						}else{
							$.ajax({
								url:"",
								data: {
									op: op,
									userId: userId,
									fullName: fullName,
									username: username,
									firstName: firstName,
									middleName: middleName,
									lastName: lastName,
									year: year,
									email: email,
									reemail: reemail,
									phoneNumber: phoneNumber,
									homeNumber: homeNumber,
									password:password,
									repass:repass,
									status:status
								},
								success: function(data){
									alert(data);
									window.location.href =("#userForm");
								}
							});
						}
					}
			);
		},
		
		myMethod: function() {
			alert("UserMaintenance.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(UserMaintenance.init()); // Run after page loads