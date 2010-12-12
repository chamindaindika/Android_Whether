package ucsc.whether;

import java.util.Hashtable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityWhetherHome extends Activity {
	Hashtable<String, String> hashTable;
	public static final String URL = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml";	
	
	EditText etcity;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whether_home);
        
        etcity = (EditText) this.findViewById(R.id.city);        
        
    }           
    
    public void onButtonGetForecast(View v){
    	String city = etcity.getText().toString();
    	String url = URL + "?query=" + city + ",LK";    	
    	Intent intent = new Intent(this, ActivityWhetherInformation.class);
    	intent.putExtra("address", url);
    	startActivity(intent);    	
    	
    }
}