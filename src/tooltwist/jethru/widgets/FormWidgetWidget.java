package tooltwist.jethru.widgets;

import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.JavascriptCodeInserter;
import tooltwist.wbd.PageImportCodeInserter;
import tooltwist.wbd.SnippetParam;
import tooltwist.wbd.StylesheetCodeInserter;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdNavPointProperty;
import tooltwist.wbd.WbdRenderHelper;
import tooltwist.wbd.WbdSizeInfo;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;
import tooltwist.wbd.WbdWidgetController;
import tooltwist.wbd.WbdProductionHelper;
import tooltwist.jethru.productionHelpers.FormWidgetProductionHelper;
import com.dinaa.ui.UimData;
import com.dinaa.ui.UimHelper;

/**
 * Form Widget
 */
public class FormWidgetWidget extends WbdWidgetController
{
	private static final String SNIPPET_PREVIEW = "formWidget_preview.html";
	private static final String SNIPPET_DESIGN = "formWidget_design.html";
	private static final String SNIPPET_PRODUCTION = "formWidget_production.jsp";
	private static final boolean USE_PRODUCTION_HELPER = true;

	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		instance.defineProperty(new WbdStringProperty("elementId", null, "Id", ""));
		instance.defineProperty(new WbdStringProperty("title", null, "Title", ""));
		instance.defineProperty(new WbdStringProperty("subTitle", null, "Sub-Title", ""));
		instance.defineProperty(new WbdStringProperty("formName", null, "Form Name", ""));
//		instance.defineProperty(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
	}
	
	@Override
	public void getCodeInserters(WbdGenerator generator, WbdWidget instance, UimData ud, CodeInserterList codeInserterList) throws WbdException
	{
//TODO: Uncomment this as required
		GenerationMode mode = generator.getMode();
		if (mode == GenerationMode.DESIGN)
		{
			// Add code inserters for design mode
			CodeInserter[] arr = {

				// Include a CSS snippet
				new StylesheetCodeInserter(generator, instance, "formWidget_cssHeader.css"),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PREVIEW)
		{
			// Add code inserters for preview mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),

//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),

				// Include a javascript snippet 
				new JavascriptCodeInserter(generator, instance, "formWidget_jsHeader.js"),

				// Include a CSS snippet
				new StylesheetCodeInserter(generator, instance,  "formWidget_cssHeader.css"),
			};
			codeInserterList.add(arr);
		}
		else if (mode == GenerationMode.PRODUCTION || generator.getMode() == GenerationMode.CONTROLLER)
		{
			// Add code inserters for production mode
			CodeInserter[] arr = {
//				// Link to an external Javascript file
//				new JavascriptLinkInserter(jsUrl),
					
//				// Link to an external stylesheet
//				new StylesheetLinkInserter(cssUrl),
					
				// Include a javascript snippet 
				new JavascriptCodeInserter(generator, instance, "formWidget_jsHeader.js"),
					
				// Include a CSS snippet
				new StylesheetCodeInserter(generator, instance,  "formWidget_cssHeader.css"),

//				// Add import statements to the JSP
//				new PageImportCodeInserter(XData.class.getName()),
			};
			codeInserterList.add(arr);

			if (USE_PRODUCTION_HELPER)
			{
				SnippetParam[] productionHelperParams = null;
				codeInserterList.add(WbdProductionHelper.codeInserter(instance, FormWidgetProductionHelper.class.getName(), productionHelperParams));
				codeInserterList.add(new PageImportCodeInserter(FormWidgetProductionHelper.class.getName()));
			}
		}

	}
	
	@Override
	public String getLabel(WbdWidget instance) throws WbdException
	{
		return "Form Widget";
	}
	
	@Override
	public WbdSizeInfo getSizeInfo(WbdGenerator generator, WbdWidget instance) throws WbdException
	{
		return WbdSizeInfo.unknownSizeInfo();
	}
	
	@Override
	public void renderForPreview(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_PREVIEW, getSnippetParams(generator, instance, ud));
	}
	
	@Override
	public void renderForDesigner(WbdGenerator generator, WbdWidget instance, UimData ud, WbdRenderHelper rh) throws WbdException
	{
		rh.renderSnippetForStaticPage(generator, instance, SNIPPET_DESIGN, getSnippetParams(generator, instance, ud));
	}
	
	@Override
	public void renderForJSP(WbdGenerator generator, WbdWidget instance, UimHelper ud, WbdRenderHelper rh) throws Exception
	{
		rh.beforeProductionCode(generator, instance, getSnippetParams(generator, instance, ud), USE_PRODUCTION_HELPER);
		rh.renderSnippetForProduction(generator, instance, SNIPPET_PRODUCTION);
		rh.afterProductionCode(generator, instance);
	}
	
	private SnippetParam[] getSnippetParams(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
		String title = instance.getProperty("title", null);
		String subTitle = instance.getProperty("subTitle", null);
		String formName = instance.getProperty("formName", null);
//		String myNavpoint = instance.getProperty("myNavpoint", null);
		SnippetParam[] params = {
			new SnippetParam("title", title),
			new SnippetParam("subTitle", subTitle),
			new SnippetParam("formName", formName)
//			new SnippetParam("myNavpoint", myNavpoint)
		};
		return params;
	}
}
