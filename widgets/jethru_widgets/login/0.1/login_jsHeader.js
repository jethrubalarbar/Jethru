
var Login = function() {
	return {
		myVariable: null,

		init: function() {
			

			jQuery("#submitButtonID").click(
					function() {
						
						var op = $("#op").val();
						var username = $("#usernameFieldID").val();
						var password = $("#passwordFieldID").val();
						var userId=1;
						var isValid = true;
						var msg = "";

						if(username ==""){
							msg += "Username is required!\n";
							isValid = false;
						}if(password ==""){
							msg += "Password is required!\n";
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
									username: username,
									password: password

								},
								success: function(data){
									if(data  != "Bro, wrong password or username!"){
										alert("You have successfully Logged In!");
										window.location.href =$("#studentLogin").attr("action") + data;
									}else{
										alert("Bro, you are not frome here!");
										window.location.href ="jethru-17";	
									}
									
								}
							});
						}
					}
			);

		},
		
		myMethod: function() {
			alert("Login.myMethod()");
		}
		// no comma after last method
	};
}();

jQuery(Login.init()); // Run after page loads