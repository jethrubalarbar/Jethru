package tooltwist.jethru.xds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.dinaa.xpc.XDS;
import com.dinaa.xpc.XpcException;
import com.dinaa.xpc.XpcSecurity;
import com.tooltwist.xdata.XD;
import com.tooltwist.xdata.XDException;
import com.tooltwist.xdata.XSelector;

public class Xds extends XDS{	
	
	private JSONObject input;
	private XD out;
	private XpcSecurity xpcSecurity;
	private String name;
	private String method;
	
	public Xds(XpcSecurity xpcSecurity) throws XpcException {
		this.xpcSecurity = xpcSecurity;
		input = new JSONObject();
	}
	
	public Xds(XD setOutput) {
		out = setOutput;
	}
	
	public void attrib(String name, String value) {
		input.put(name, value);
	}
	
	public void attrib(String name, String[] value) {
		input.put(name, value);
	}
	
	public void attrib(String name, Collection<String> value) {
		input.put(name, value);
	}
	
	public void attrib(String name, Object[] value) {
		input.put(name, value);
	}
	
	public void attrib(String name, int value) {
		input.put(name, value);
	}
	
	public void start(String name, String method) {
		input.put("method", method);
		this.name = name;
		this.method = method;
	}
	
	public XD run() throws XpcException, XDException {
		out = XDS.call(xpcSecurity, this.name, this.method, new XD(input.toString()));
		
		return out;
	}

	public XD sortElements(String node,boolean isAscending, String...sortBy) throws XDException {
		
		if(out == null) {
			return out;
		}
		
		String str = out.toString();
		str = str.replace("XD:", "");
		
		String[] split = node.split("/");
		split = clean(split);
		int length = split.length;
		
		JSONObject outtmp = JSONObject.fromObject(str);
		JSONObject fromObject = JSONObject.fromObject(str);
		JSONArray tmpList = new  JSONArray();
		
		List<Map<String,Object>> jList = new ArrayList<Map<String,Object>>();
		Map<String, Object> tmpMap = new HashMap<String,Object>();
		tmpMap.put("rootObj", outtmp);
		jList.add(tmpMap);
		
		try {
			for(int x=0;x<length;x++) {
				Map<String, Object> map = new HashMap<String,Object>();
				if(fromObject != null && !fromObject.isNullObject()) {
					if(length == x+1) {
						tmpList = fromObject.getJSONArray(split[x]);
						map.put(split[x], tmpList);
					}else {
						fromObject = fromObject.getJSONObject(split[x]);
						map.put(split[x], fromObject);
					}
					if(fromObject != null && !fromObject.isNullObject())
						jList.add(map);
				}else{
					break;
				}
			}
		} catch (JSONException e) {
			return out;
		}
		
		JSONObject jsonObject = new JSONObject();
		
		if(tmpList.size()>0) {
			Object[] array = tmpList.toArray();
			int sortLen = sortBy.length;
			for(int x=sortLen; x>0;x--) {
				Arrays.sort(array, new JsonComparator(sortBy[x-1]));
			}
			if(!isAscending) {
				List<Object> asList = Arrays.asList(array);
				Collections.reverse(asList);
				array = asList.toArray();
			}
			
			tmpList = JSONArray.fromObject(array);

			Collections.reverse(jList);
			Object prevObj = new Object();
			String prevKey = "";
			for(Map<String, Object> map:jList) {
				for(String tmp: map.keySet()) {
					
					if(!prevKey.equals("")) {
						JSONObject tmpJson = (JSONObject) map.get(tmp);
						tmpJson.remove(prevKey);
						tmpJson.put(prevKey, prevObj);
						prevObj = tmpJson;
					}else {
						prevObj = tmpList;
					}
					prevKey = tmp;
					
				}
				
				if(prevObj instanceof JSONObject)
					jsonObject = (JSONObject) prevObj;
			}
		}else {
			return out;
		}
		
		out = null;
		out = new XD(jsonObject.toString());
		
		return out;
	}
	
	public String[] clean(final String[] v) {
	    List<String> list = new ArrayList<String>(Arrays.asList(v));
	    list.removeAll(Collections.singleton(null));
	    list.removeAll(Collections.singleton(String.valueOf("")));
	    return list.toArray(new String[list.size()]);
	}
	
	public XD sortElements(String node, String...sortBy) throws XDException {
		return sortElements(node,true,sortBy);
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)  {
		
		JSONArray arr = new JSONArray();
		
		JSONObject tmp1 = new JSONObject();

		
		for(int x=0;x<10;x++) {
			int randInt = randInt(10,300000);
			tmp1 = new JSONObject();
			tmp1.put("name", "aaa"+randInt);
			tmp1.put("age", randInt);
			arr.add(tmp1);
		}
	
		
		JSONObject res1= new JSONObject();
		res1.put("id", 1 );
		res1.put("sampleData", 1000 );
		res1.put("list", arr );
		
		JSONObject res = new JSONObject();
		res.put("select", res1);
		res.put("tmp",false);
		res1 = new JSONObject();
		res1.put("select1", res);
		res1.put("bool", true);
		
		try {
			XD xd = new XD("{\"select\":{\"HttpStatus\":{\"HttpStatusId\":\"200\",\"HttpStatusDescription\":\"OK\"},\"Available\":[{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":33000,\"ImprovementValue\":79000,\"CreatedOn\":\"1991-01-20T19:45:51+00:00\",\"RatingValuationId\":782346,\"CapitalValue\":112000,\"ValuationDate\":\"1987-05-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":50000,\"ImprovementValue\":125000,\"CreatedOn\":\"1991-01-20T19:45:51+00:00\",\"RatingValuationId\":795236,\"CapitalValue\":175000,\"ValuationDate\":\"1987-05-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":50000,\"ImprovementValue\":125000,\"CreatedOn\":\"1991-01-22T20:53:43+00:00\",\"RatingValuationId\":828149,\"CapitalValue\":175000,\"ValuationDate\":\"1990-10-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":56000,\"ImprovementValue\":119000,\"CreatedOn\":\"1993-12-11T09:37:37+00:00\",\"RatingValuationId\":3452665,\"CapitalValue\":175000,\"ValuationDate\":\"1993-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":67000,\"ImprovementValue\":93000,\"CreatedOn\":\"1996-03-30T14:51:43+00:00\",\"RatingValuationId\":4720351,\"CapitalValue\":160000,\"ValuationDate\":\"1995-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":70000,\"ImprovementValue\":100000,\"CreatedOn\":\"1997-03-29T11:47:07+00:00\",\"RatingValuationId\":5409444,\"CapitalValue\":170000,\"ValuationDate\":\"1996-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":74000,\"ImprovementValue\":111000,\"CreatedOn\":\"1998-03-28T09:20:44+00:00\",\"RatingValuationId\":6039098,\"CapitalValue\":185000,\"ValuationDate\":\"1997-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":74000,\"ImprovementValue\":111000,\"CreatedOn\":\"1999-03-27T11:23:00+00:00\",\"RatingValuationId\":6863625,\"CapitalValue\":185000,\"ValuationDate\":\"1998-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":84000,\"ImprovementValue\":126000,\"CreatedOn\":\"2000-02-26T00:48:53+00:00\",\"RatingValuationId\":7489578,\"CapitalValue\":210000,\"ValuationDate\":\"1999-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":88000,\"ImprovementValue\":132000,\"CreatedOn\":\"2000-11-18T02:38:10+00:00\",\"RatingValuationId\":8133783,\"CapitalValue\":220000,\"ValuationDate\":\"2000-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":88000,\"ImprovementValue\":132000,\"CreatedOn\":\"2001-11-03T02:30:52+00:00\",\"RatingValuationId\":8858892,\"CapitalValue\":220000,\"ValuationDate\":\"2001-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":106000,\"ImprovementValue\":129000,\"CreatedOn\":\"2002-11-16T00:39:20.743+00:00\",\"RatingValuationId\":9992357,\"CapitalValue\":235000,\"ValuationDate\":\"2002-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":122000,\"ImprovementValue\":138000,\"CreatedOn\":\"2003-11-22T01:45:04.937+00:00\",\"RatingValuationId\":10923108,\"CapitalValue\":260000,\"ValuationDate\":\"2003-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":100,\"LandValue\":160000,\"ImprovementValue\":150000,\"CreatedOn\":\"2004-11-20T01:19:04.077+00:00\",\"RatingValuationId\":11789905,\"CapitalValue\":310000,\"ValuationDate\":\"2004-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":128,\"LandValue\":160000,\"ImprovementValue\":190000,\"CreatedOn\":\"2005-03-31T12:30:56.577+00:00\",\"RatingValuationId\":12150469,\"CapitalValue\":350000,\"ValuationDate\":\"2004-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":128,\"LandValue\":185000,\"ImprovementValue\":200000,\"CreatedOn\":\"2005-10-29T01:23:28.1+00:00\",\"RatingValuationId\":12677615,\"CapitalValue\":385000,\"ValuationDate\":\"2005-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":128,\"LandValue\":205000,\"ImprovementValue\":220000,\"CreatedOn\":\"2006-10-21T01:25:09.867+00:00\",\"RatingValuationId\":13588230,\"CapitalValue\":425000,\"ValuationDate\":\"2006-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":128,\"LandValue\":235000,\"ImprovementValue\":260000,\"CreatedOn\":\"2007-11-03T01:33:39.903+00:00\",\"RatingValuationId\":14429316,\"CapitalValue\":495000,\"ValuationDate\":\"2007-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":128,\"LandValue\":225000,\"ImprovementValue\":260000,\"CreatedOn\":\"2009-10-24T02:09:37.78+00:00\",\"RatingValuationId\":16259319,\"CapitalValue\":485000,\"ValuationDate\":\"2009-09-01T00:00:00+00:00\"},{\"LandArea\":0.0519,\"BuildingFloorArea\":128,\"LandValue\":225000,\"ImprovementValue\":260000,\"CreatedOn\":\"2012-10-27T01:57:30.753+00:00\",\"RatingValuationId\":18598612,\"CapitalValue\":485000,\"ValuationDate\":\"2012-09-01T00:00:00+00:00\"}]}}");
			System.out.println(xd.toString());
			XSelector select = xd.select("//Available");
			System.out.println(select.size());
			Xds xds = new Xds(xd);
			XD sortElements = xds.sortElements("/select/Available", "ValuationDate","CreatedOn","RatingValuationId");
			System.out.println(sortElements.toString());
			select = sortElements.select("//Available");
			System.out.println(select.size());
			sortElements = xds.sortElements("/select/Available",false, "ValuationDate","CreatedOn","RatingValuationId");
			System.out.println(sortElements.toString());
			select = sortElements.select("//Available");
			System.out.println(select.size());
		} catch (XDException e) {
			e.printStackTrace();
		}
	}

	
}
