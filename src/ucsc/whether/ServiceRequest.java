package ucsc.whether;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import org.xmlpull.v1.XmlPullParserException;


public class ServiceRequest{	
	public static Hashtable<String, String> ht;	
	public static XmlParser xp;
	
	public BufferedReader getConnect(String url) throws IOException, XmlPullParserException {
		String URL = url;		
	    HttpClient client = new DefaultHttpClient();
	    HttpGet get = new HttpGet(URL);
	    HttpResponse response = client.execute(get);
	    InputStream in = response.getEntity().getContent();
	    InputStreamReader is = new InputStreamReader(in);
	    BufferedReader br = new BufferedReader(is);	
	    
		return br;
    }
	
	
}