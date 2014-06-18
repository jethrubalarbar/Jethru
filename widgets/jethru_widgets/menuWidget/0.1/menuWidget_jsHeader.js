
var MenuWidget = function() {
	return {
		myVariable: null,

		init: function() {
			alert("MenuWidget.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".MenuWidget .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("MenuWidget.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(MenuWidget.init()); // Run after page loads