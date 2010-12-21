package ucsc.whether;

import java.util.HashMap;
import java.util.Hashtable;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class ActivityWhetherInformation extends TabActivity {
	static Hashtable<String, String> hashTable;	
	static XmlParser xp;
	static ProgressDialog pd;
	String url;
		
	/** Called when the activity is first created. */    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whether_information);                           
        
		@SuppressWarnings("unchecked")
		HashMap<String, String> hashMap = (HashMap<String, String>) getIntent().getSerializableExtra("address");    
        
        Resources res = getResources();
        TabHost tabHost = getTabHost();  
        TabHost.TabSpec spec;  
        Intent intent;        
            
        intent = new Intent().setClass(this, ActivityTabTemparature.class).putExtra("hash", hashMap);
        spec = tabHost.newTabSpec("temp").setIndicator("Temparature", res.getDrawable(R.drawable.ic_tab_temparature)).setContent(intent);
        tabHost.addTab(spec);        
            
        intent = new Intent().setClass(this, ActivityTabWind.class).putExtra("hash", hashMap);;
        spec = tabHost.newTabSpec("wind").setIndicator("Wind", res.getDrawable(R.drawable.ic_tab_wind)).setContent(intent);
        tabHost.addTab(spec);
            
        intent = new Intent().setClass(this, ActivityTabPressure.class).putExtra("hash", hashMap);;
        spec = tabHost.newTabSpec("press").setIndicator("Pressure", res.getDrawable(R.drawable.ic_tab_pressure)).setContent(intent);
        tabHost.addTab(spec);
            
        intent = new Intent().setClass(this, ActivityLocationInformation.class).putExtra("hash", hashMap);;
        spec = tabHost.newTabSpec("location").setIndicator("Location", res.getDrawable(R.drawable.ic_tab_location)).setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);    	          	    
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
