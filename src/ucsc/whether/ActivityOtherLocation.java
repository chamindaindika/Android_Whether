package ucsc.whether;

import java.io.IOException;
import java.util.Hashtable;
import java.util.regex.Pattern;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

public class ActivityOtherLocation extends Activity {	
	String city;
	public static final String URL = "http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml";	
	EditText etcity;
	ProgressDialog pd;
	
	@SuppressWarnings("static-access")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_location);
        
        etcity = (EditText) this.findViewById(R.id.EditText01);
        pd = new ProgressDialog(this);
        pd.setProgressStyle(pd.STYLE_SPINNER);
        pd.setMessage("Retriving from the Service...");        
	}
	
	public void onButtonGetForecast(View v){	
		
    	city = etcity.getText().toString();
    	if(city.length()==0){
    		showDialog(0);    		
    	}else if(city.indexOf(" ")>0){
    		showDialog(1);    		
    	}else if(Pattern.matches("[\\d].*", city) || !Pattern.matches("^.*\\D", city)){    		
    		showDialog(2);    
        }else{
        	pd.show();
	    	callService cs = new callService();
	    	cs.execute(null, null, null);
        }    	
    }	
	
	final Handler callServiceHandler = new Handler(){
    	public void handleMessage(Message message){
    		@SuppressWarnings("unchecked")
			Hashtable<String, String> serviceResult = (Hashtable<String, String>) message.getData().getSerializable("serviceResult");    		 		
    		if(serviceResult.get("city").length()>2 & serviceResult.get("elevation").length()>3){
	    		Intent intent = new Intent(ActivityOtherLocation.this, ActivityWhetherInformation.class);
		    	intent.putExtra("address", serviceResult);
		    	startActivity(intent);
		    	pd.dismiss();
    		}else{
    			showDialog(3);  
    			pd.dismiss();
    		}
    	}
    };
	
	class callService extends AsyncTask<Object, Object, Object>{
		Hashtable<String, String> hashTable;
		XmlParser xp;

		@Override
		protected Object doInBackground(Object... params) {
			String url = URL + "?query=" + city + ",LK";
			System.out.println(url);
				try{	    	        	
		        	xp = new XmlParser();
		            hashTable = xp.process(url,1);		            
				}catch (IOException e){
			    	//e.printStackTrace();	    	
			    	showDialog(0);
			    }catch (XmlPullParserException ex){
			    	ex.printStackTrace();
			    }    
			    
			    Message message = callServiceHandler.obtainMessage();
			    Bundle bundle = new Bundle();
			    bundle.putSerializable("serviceResult", hashTable);			   
			    message.setData(bundle);
			    callServiceHandler.sendMessage(message);
	        
			return null;
		}    	
    }	
	
	public AlertDialog onCreateDialog(int id){
    	AlertDialog ad;
    	String msg=null;
    	if(id==0){
    		msg="City name is required!";
    	}else if(id==1){
    		msg="City should be have only one word.";
    	}else if(id==2){
    		msg="Invalid city!";
    	}else if(id==3){
    		msg="Currently, the service is not avilable for this city!";
    	}
    	  		
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
		.setCancelable(false)		
		.setNegativeButton("OK", new DialogInterface.OnClickListener() {			
			@Override
			public void onClick(DialogInterface dialog, int id) {
				etcity.setText("");
				dialog.cancel();				
			}
		});		
		ad = builder.create();			
    	return ad;	    	
    }
	
}