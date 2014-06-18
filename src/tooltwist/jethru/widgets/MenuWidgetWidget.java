package tooltwist.jethru.widgets;

import tooltwist.wbd.CodeInserter;
import tooltwist.wbd.CodeInserterList;
import tooltwist.wbd.JavascriptCodeInserter;
import tooltwist.wbd.Navpoint;
import tooltwist.wbd.PageImportCodeInserter;
import tooltwist.wbd.SnippetParam;
import tooltwist.wbd.StylesheetCodeInserter;
import tooltwist.wbd.WbdCache;
import tooltwist.wbd.WbdException;
import tooltwist.wbd.WbdGenerator;
import tooltwist.wbd.WbdGenerator.GenerationMode;
import tooltwist.wbd.WbdNavPointProperty;
import tooltwist.wbd.WbdRenderHelper;
import tooltwist.wbd.WbdSession;
import tooltwist.wbd.WbdSizeInfo;
import tooltwist.wbd.WbdStringProperty;
import tooltwist.wbd.WbdWidget;
import tooltwist.wbd.WbdWidgetController;
import tooltwist.wbd.WbdProductionHelper;
//import tooltwist.jethru.productionHelpers.MenuWidgetProductionHelper;
import com.dinaa.ui.UimData;
import com.dinaa.ui.UimHelper;

/**
 * Menu Widget
 */
public class MenuWidgetWidget extends WbdWidgetController
{
	private static final String SNIPPET_PREVIEW = "menuWidget_preview.html";
	private static final String SNIPPET_DESIGN = "menuWidget_design.html";
	private static final String SNIPPET_PRODUCTION = "menuWidget_production.jsp";
	private static final boolean USE_PRODUCTION_HELPER = false;

	@Override
	protected void init(WbdWidget instance) throws WbdException
	{
		instance.defineProperty(new WbdStringProperty("elementId", null, "Id", ""));
//		instance.defineProperty(new WbdStringProperty("myProperty", null, "My Property", ""));
		instance.defineProperty(new WbdNavPointProperty("navpoint", null, "Navpoint", ""));
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
				new StylesheetCodeInserter(generator, instance, "menuWidget_cssHeader.css"),
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
				new JavascriptCodeInserter(generator, instance, "menuWidget_jsHeader.js"),

				// Include a CSS snippet
				new StylesheetCodeInserter(generator, instance, "menuWidget_cssHeader.css"),
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
				new JavascriptCodeInserter(generator, instance,  "menuWidget_jsHeader.js"),
					
				// Include a CSS snippet
				new StylesheetCodeInserter(generator, instance,  "menuWidget_cssHeader.css"),

//				// Add import statements to the JSP
//				new PageImportCodeInserter(XData.class.getName()),
			};
			codeInserterList.add(arr);

			if (USE_PRODUCTION_HELPER)
			{
				SnippetParam[] productionHelperParams = null;
//				codeInserterList.add(WbdProductionHelper.codeInserter(instance, MenuWidgetProductionHelper.class.getName(), productionHelperParams));
//				codeInserterList.add(new PageImportCodeInserter(MenuWidgetProductionHelper.class.getName()));
			}
		}

	}
	
	@Override
	public String getLabel(WbdWidget instance) throws WbdException
	{
		return "Menu Widget";
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
		//Get navpiont property value
		String navpointId = instance.getProperty("navpoint", null);
		//find navpoint class for the navpoint ID
		Navpoint navpoint = WbdCache.findNavPoint(navpointId, false);
		//Get active navpoint
		String currentNavpointId = WbdSession.getNavpointId(ud.getCredentials());
		
		rh.beforeProductionCode(generator, instance, getSnippetParams(generator, instance, ud), USE_PRODUCTION_HELPER);
		//rh.renderSnippetForProduction(generator, instance, SNIPPET_PRODUCTION);
		rh.append("<div id='cssmenu'>\n");
		generateMenu(navpoint, currentNavpointId, rh);
		rh.append("</div>");
		
		rh.afterProductionCode(generator, instance);
	}
	
	private void generateMenu(Navpoint navpoint, String currentNavpointId, WbdRenderHelper rh) {

		
		rh.append("<ul>\n");
		
		//traverse all the children of navpoint
		for (Navpoint nav : navpoint.getChildren())
		{
			String activeClass="";
			if(currentNavpointId.equals(nav.getId())){
				activeClass = "active";
			}
			
			//checking childrens of navpoints
			boolean hasChildren = nav.hasChildren(true);
			String hasSubClass = "";
			if(hasChildren){
				hasSubClass = "has-sub";
			}
			
			rh.append("<li class='"+activeClass+" "+hasSubClass+"'><a href='"+nav.getId()+"'><span>"+nav.getLabel()+"</span></a>" );
			
					if(hasChildren){	
						generateMenu(nav, currentNavpointId, rh);
						//rh.append("<ul>\n") ; 
	//					for (Navpoint subNav : nav.getChildren()){
	//							rh.append("<li class='"+hasSubClass+"'><a href='"+subNav.getId()+"'><span>"+subNav.getLabel()+"</span></a>");
	//							if(hasChildren){					
	//								rh.append("<ul>\n") ; 
	//								for (Navpoint subsubNav : subNav.getChildren()){
	//										rh.append("<li class=''><a href='"+subsubNav.getId()+"'><span>"+subsubNav.getLabel()+"</span></a></li>\n");
	//								}
	//								rh.append("</ul>\n");
	//							}
	//							rh.append("</li>\n");
	//					}
						//rh.append("</ul>\n");
				}
			
			//end of parent menu
			rh.append("</li>\n");
			}
		
		rh.append("</ul>\n");
	}

	private SnippetParam[] getSnippetParams(WbdGenerator generator, WbdWidget instance, UimData ud) throws WbdException {
//		String myProperty = instance.getProperty("myProperty", null);
		String navpoint = instance.getProperty("navpoint", null);
		SnippetParam[] params = {
//			new SnippetParam("myProperty", myProperty),
			new SnippetParam("navpoint", navpoint)
		};
		return params;
	}
}
