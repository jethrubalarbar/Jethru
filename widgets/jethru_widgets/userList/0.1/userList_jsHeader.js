
var UserList = function() {
	return {
		myVariable: null,

		init: function() {
			alert("UserList.init()");


		},
		
		myMethod: function() {
			alert("UserList.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(UserList.init()); // Run after page loads