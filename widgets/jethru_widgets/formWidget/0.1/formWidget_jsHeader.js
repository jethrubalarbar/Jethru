
var FormWidget = function() {
	return {
		myVariable: null,

		init: function() {
			alert("FormWidget.init()");

//			// attach an event to an HTML element
//			var self = this;
//			jQuery(".FormWidget .myElementClass").click(function() {
//				self.myMethod();
//				// do something
//				...
//			});
		},
		
		myMethod: function() {
			alert("FormWidget.myMethod()");
		}
		// no comma after last method
	};
}();

//jQuery(FormWidget.init()); // Run after page loads