package ucsc.whether;

import java.io.IOException;
import java.util.Hashtable;

import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityWhetherHome extends ListActivity {
	XmlParser xp1;
	Hashtable<String, String> ht1;
	static final String[] listItems = new String[] {
		"Current Location",
		"Other Location"
	};		
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setListAdapter(new ArrayAdapter<String>(this, R.layout.whether_home, listItems));
        
    	ListView lv = getListView();
    	lv.setTextFilterEnabled(true);
        
    	lv.setOnItemClickListener(new OnItemClickListener() {
    	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {    	      
    	    	Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
    	    	Toast.LENGTH_SHORT).show();
    	    	
    	    	String selectedItem = (String) ((TextView) view).getText();
    	    	if(selectedItem== "Current Location"){
    	    		String url = "http://maps.googleapis.com/maps/api/geocode/xml?latlng=33.993,-84.859&sensor=true";
    	    		loadActivityWhether(url);
    			}else if(selectedItem== "Other Location"){    				
    				loadActivity();    				
    			}
    	    	
    	    }
    	  });
    	       
    }         
    
    public void loadActivity(){
    	startActivity(new Intent(this, ActivityOtherLocation.class));
    }
    
    public void loadActivityWhether(String url){
    	try{	    	        	
        	xp1 = new XmlParser();
            ht1 = xp1.process(url,0);    	                
            String cityname = ht1.get("cityname");    	            	    	
        	Intent intent = new Intent(this, ActivityWhetherInformation.class);
        	String otherLocationURL = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml?query="+cityname+",LK";
        	System.out.println(otherLocationURL);
        	intent.putExtra("address", otherLocationURL);
        	startActivity(intent);
	    }catch (IOException e){	    	
	    	showDialog(0);
	    	//e.printStackTrace();	    	
	    }catch (XmlPullParserException ex){
	    	ex.printStackTrace();
	    }
    }
    
    public AlertDialog onCreateDialog(int id){
    	AlertDialog ad;
    	String msg="Problem with your Internet Connection. Please try again later.";    	    	  		
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