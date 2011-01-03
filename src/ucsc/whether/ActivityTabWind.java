package ucsc.whether;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityTabWind extends Activity {	
	//TextView tvWind;
	TextView tvDir;
	TextView tvDegree;
	TextView tvSpeed;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_wind);
        
        @SuppressWarnings("unchecked")
		HashMap<String, String> ht = (HashMap<String, String>) getIntent().getSerializableExtra("hash");
    
        tvDir = (TextView) this.findViewById(R.id.TextView04);
        tvDegree = (TextView) this.findViewById(R.id.TextView06);
        tvSpeed = (TextView) this.findViewById(R.id.TextView08);        
        
        if(ht.get("wind_dir").length()>0){
        	tvDir.setText(ht.get("wind_dir"));
        }else{
        	tvDir.setText("N/A");
        }
        if(ht.get("wind_degrees").length()>0){
        	tvDegree.setText(ht.get("wind_degrees")+ "º");
        }else{
        	tvDegree.setText("N/A");
        }
        if(ht.get("wind_mph").length()>0){
        	tvSpeed.setText(ht.get("wind_mph")+" mph");
        }else{
        	tvSpeed.setText("N/A");
        }
        
        
    }
}