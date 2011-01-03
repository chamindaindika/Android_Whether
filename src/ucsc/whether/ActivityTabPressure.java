package ucsc.whether;

import java.text.DecimalFormat;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityTabPressure extends Activity {	
	TextView tvPressure;
	TextView tvPressuremb;
	TextView tvPressurein;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_pressure);
        
        @SuppressWarnings("unchecked")
		HashMap<String, String> ht = (HashMap<String, String>) getIntent().getSerializableExtra("hash");
        
        tvPressurein = (TextView) this.findViewById(R.id.TextView02);        
        tvPressuremb = (TextView) this.findViewById(R.id.TextView04);
        tvPressure = (TextView) this.findViewById(R.id.TextView06);
          
        if(ht.get("pressure_mb").length()>0){
        	tvPressuremb.setText(convertToDouble(ht.get("pressure_mb")).toString()+" mb");
        }else{
        	tvPressuremb.setText("N/A");
        }
        if(ht.get("pressure_in").length()>0){
        	tvPressurein.setText(convertToDouble(ht.get("pressure_in")).toString()+" inHg");
        	Double incm = convertToDouble(ht.get("pressure_in"))*2.54;  
            tvPressure.setText(convertToDouble(incm.toString()).toString()+ " cmHg");
        }else{
        	tvPressurein.setText("N/A");
        	tvPressure.setText("N/A");
        }
                
        
    }
    
    public Double convertToDouble(String val){   	
    	Double dd = Double.valueOf(val);
    	DecimalFormat df = new DecimalFormat("#.##");    	
    	return Double.valueOf(df.format(dd));
    }
}