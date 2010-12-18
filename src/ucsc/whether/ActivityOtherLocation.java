package ucsc.whether;

import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityOtherLocation extends Activity {
	public static final String URL = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml";
	EditText etcity;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_location);
        
        etcity = (EditText) this.findViewById(R.id.EditText01);  
        
	}
	
	public void onButtonGetForecast(View v){
    	String city = etcity.getText().toString();
    	if(city.length()==0){
    		showDialog(0);
    	}else if(city.indexOf(" ")>0){
    		showDialog(1);
    	//}else if(Pattern.matches("[0-9]", city)){
        	//showDialog(2);
        }else{
    		String url = URL + "?query=" + city + ",LK";    	
	    	Intent intent = new Intent(this, ActivityWhetherInformation.class);
	    	intent.putExtra("address", url);
	    	startActivity(intent);  
    	}    	
    }
	
	public AlertDialog onCreateDialog(int id){
    	AlertDialog ad;
    	String msg=null;
    	if(id==0){
    		msg="City name is required!";
    	}else if(id==1){
    		msg="City should be have only one word.";
    	//}else if(id==2){
    		//msg="Cityname should not be have numbers.";
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