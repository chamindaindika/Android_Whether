package ucsc.whether;

import java.io.IOException;
import java.util.Hashtable;

import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityWhetherHome extends ListActivity {
	
	ProgressDialog pd;
	static final String[] listItems = new String[] {
		"Current Location",
		"Other Location"
	};		
	
    /** Called when the activity is first created. */
    @SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                
        setListAdapter(new ArrayAdapter<String>(this, R.layout.whether_home, listItems));
        
    	ListView lv = getListView();
    	lv.setTextFilterEnabled(true);
    	
    	pd = new ProgressDialog(this);
        pd.setProgressStyle(pd.STYLE_SPINNER);
        pd.setMessage("Retriving from the Service...");
        
    	lv.setOnItemClickListener(new OnItemClickListener() {
    		
    	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {    	      
    	    	Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
    	    	Toast.LENGTH_SHORT).show();    	    	
    	    	String selectedItem = (String) ((TextView) view).getText();
    	    	
    	    	if(selectedItem== "Current Location"){
    	    		try{
    	    			pd.show();
	    	    		LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);       	    		
	    	    		Criteria crit = new Criteria();
	    	    		crit.setAccuracy(Criteria.ACCURACY_FINE);
	    	    		String provider = lm.getBestProvider(crit, true);
	    	    		Location loc = lm.getLastKnownLocation(provider);
	    	    		//Location loc = lm.getCurrentLocation("gps");
						Double lat = loc.getLatitude();  	
						Double lng = loc.getLongitude();  
						System.out.println(lat.toString());
	    	    		String url = "http://maps.googleapis.com/maps/api/geocode/xml?latlng="+lat.toString()+","+lng.toString()+"&sensor=true";     	    		
	    	    		System.out.println(url);	    	    		
						//String url = "http://maps.googleapis.com/maps/api/geocode/xml?latlng=6.858,79.884&sensor=true";
	    				callService cs = new callService();
	    				cs.setURL(url);
	    				cs.execute(null,null,null);
    	    		}catch (NullPointerException npe){
    	    			pd.dismiss();
    	    			showDialog(1);    	    			
    	    		}
    			}else if(selectedItem== "Other Location"){     				
    				loadActivity();    				
    			}    	    	
    	    }
    	  });    	       
    }         
    
    public void loadActivity(){
    	startActivity(new Intent(this, ActivityOtherLocation.class));
    }
    
    final Handler callServiceHandler = new Handler(){
    	public void handleMessage(Message message){
    		@SuppressWarnings("unchecked")
			Hashtable<String, String> serviceResult = (Hashtable<String, String>) message.getData().getSerializable("serviceResult");
    		Intent intent = new Intent(ActivityWhetherHome.this, ActivityWhetherInformation.class);
    		intent.putExtra("address", serviceResult);
    		startActivity(intent);
	    	pd.dismiss();
    	}
    };    
    
    class callService extends AsyncTask<Object, Object, Object>{   	
    	XmlParser xp1;
    	Hashtable<String, String> ht1;
    	Hashtable<String, String> ht2;
    	Hashtable<String, String> ht3;
    	String geoCodingURL;
    	String countryCodeURL;
    	
		@Override
		protected Object doInBackground(Object... params) {
			try{	    	        	
	        	xp1 = new XmlParser();
	            ht1 = xp1.process(geoCodingURL,0);    	                
	            String cityname = ht1.get("cityname");  
	            
	            countryCodeURL = "http://ws.geonames.org/countryCode?lat=6.858&lng=79.884&style=full&type=XML";
	            ht3 = xp1.process(countryCodeURL, 2);	          	            
	            String countryCode = ht3.get("countryCode");
	            
	        	String otherLocationURL = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml?query="+cityname+","+countryCode;
	        	System.out.println(otherLocationURL);
	        	ht2 = xp1.process(otherLocationURL, 1);	    
	        	
		    }catch (IOException e){ 		    	
		    	showDialog(0);		    	
		    }catch (XmlPullParserException ex){
		    	ex.printStackTrace();
		    }
		    
		    Message message = callServiceHandler.obtainMessage();
		    Bundle bundle = new Bundle();
		    bundle.putSerializable("serviceResult", ht2);
		    message.setData(bundle);
		    callServiceHandler.sendMessage(message);
			
			return null;
		}
		
		protected void setURL(String add){
			this.geoCodingURL = add;
		}
    	
    }
    
    public AlertDialog onCreateDialog(int id){
    	AlertDialog ad;
    	String msg=null;
    	if(id==0){
    		msg="Problem with your Internet Connection. Please try again later.";    	    	  		
    	}else if(id==1){
    		msg="Problem with the GPS Connectivity. Please try again later.";
    	}
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
		.setCancelable(false)		
		.setNegativeButton("OK", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int id) {				
				dialog.cancel();					
			}
		});		
		ad = builder.create();			
    	return ad;	    	
    }
    
}