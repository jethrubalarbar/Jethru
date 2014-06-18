
var StudentList = function() {
	return {
		myVariable: null,

		init: function() {
			alert("StudentList.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".StudentList .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("StudentList.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(StudentList.init()); // Run after page loads