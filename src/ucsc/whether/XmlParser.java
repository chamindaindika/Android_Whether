package ucsc.whether;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


public class XmlParser {
	public static Hashtable<String, String> ht = new Hashtable<String, String>();
	
	public Hashtable<String, String> process(String url, int para) throws IOException, XmlPullParserException{
		
		ServiceRequest sr = new ServiceRequest();
		BufferedReader br = sr.getConnect(url);				
		
		KXmlParser parse = new KXmlParser();	    
		parse.setInput(br);	
		
		if(para==1){
			parse.nextTag();
			parse.require(XmlPullParser.START_TAG, null, "current_observation");
			
			int x=1;
			while(x<=3){
				parse.nextTag();
				parse.nextText();
				x++;
			}		
			
			while(parse.nextTag() == XmlPullParser.START_TAG) {
				//parse.require(XmlPullParser.START_TAG, null, "image");
				//image element	
				parse.nextTag();			
				parse.nextText();			
				parse.nextTag();			
				parse.nextText();
				parse.nextTag();			
				parse.nextText();	
				//end of image element
				
				parse.nextTag();
				parse.nextTag();
				
				parse.require(XmlPullParser.START_TAG, null, "display_location");			
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				//end of display_location
				
				parse.nextTag();
				parse.nextTag();
				
				parse.require(XmlPullParser.START_TAG, null, "observation_location");
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put("ob"+parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				//end of observation_location
				
				parse.nextTag();
							
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				ht.put(parse.getName(), parse.nextText());
				//System.out.println(parse.getName() + parse.nextText());
				parse.nextTag();
				System.out.println(parse.getName() + parse.nextText());
				//String aaa = ht.get("full");
				//System.out.println("value of full is " + aaa);
				parse.nextTag();			
				parse.nextTag();
				parse.nextTag();
				parse.nextText();
			}				
		}else if(para==0){			
			parse.nextTag();			
			parse.nextTag();
			
			parse.nextText();			
			parse.nextTag();			
			parse.nextTag();
			
			parse.nextText();
			parse.nextTag();
			System.out.println(parse.getLineNumber());			
			//System.out.println(parse.getName() + parse.nextText());
			//System.out.println(getCity(parse.nextText()));
			//ht.put("cityname", parse.nextText());^[^\\d].*
			
			String address = parse.nextText();
			String arr[];
			
			arr = address.split(",");	
			
			for(String item : arr){
				if(Pattern.matches("[^\\d].*", item)){
					System.out.println(item);					
				}	
			}
		}			
				
		return ht;
	}
	
		
	/*public String getCity(String add){
		String aaa=null;
		List<String> result  = new LinkedList<String>();
		String address = add;
		String arr[];
		
		arr = address.split(",");		
		for(String item : arr){
			if(!Pattern.matches("[A-Z]", item)){
				System.out.println(item);
				aaa = item;
			}			
		}
		//String a[] = result.toArray(arr);
		//System.out.println(result.size());
		return aaa;
	}*/
	
}