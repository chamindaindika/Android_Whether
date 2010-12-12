package ucsc.whether;

import java.io.IOException;
import java.util.Hashtable;

import org.xmlpull.v1.XmlPullParserException;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class ActivityWhetherInformation extends TabActivity {
	static Hashtable<String, String> hashTable;
	static XmlParser xp;	
		
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whether_information);        
        
        String url = getIntent().getStringExtra("address");  
                
        try{	    	        	
        	xp = new XmlParser();
            hashTable = xp.process(url);       	        	
	    }catch (IOException e){
	    	e.printStackTrace();
	    }catch (XmlPullParserException ex){
	    	ex.printStackTrace();
	    }
        
        Resources res = getResources();
        TabHost tabHost = getTabHost();  
        TabHost.TabSpec spec;  
        Intent intent;
        
        intent = new Intent().setClass(this, ActivityTabTemparature.class).putExtra("hash", hashTable);
        spec = tabHost.newTabSpec("temp").setIndicator("Temparature", res.getDrawable(R.drawable.ic_tab_temparature)).setContent(intent);
        tabHost.addTab(spec);        
        
        intent = new Intent().setClass(this, ActivityTabWind.class).putExtra("hash", hashTable);;
        spec = tabHost.newTabSpec("wind").setIndicator("Wind", res.getDrawable(R.drawable.ic_tab_wind)).setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, ActivityTabPressure.class).putExtra("hash", hashTable);;
        spec = tabHost.newTabSpec("press").setIndicator("Pressure", res.getDrawable(R.drawable.ic_tab_pressure)).setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, ActivityLocationInformation.class).putExtra("hash", hashTable);;
        spec = tabHost.newTabSpec("location").setIndicator("Location", res.getDrawable(R.drawable.ic_tab_location)).setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(0);
                	    
    }
}
