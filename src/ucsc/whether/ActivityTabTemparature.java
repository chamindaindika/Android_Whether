package ucsc.whether;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityTabTemparature extends Activity {	
	TextView tvTemparature_f;
    TextView tvTemparature_c;
    TextView tvhumidity;
    
	public void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_temparature);  
        
		@SuppressWarnings("unchecked")
		HashMap<String, String> ht = (HashMap<String, String>) getIntent().getSerializableExtra("hash");
                
        tvTemparature_c = (TextView) this.findViewById(R.id.TextView02);
        tvTemparature_f = (TextView) this.findViewById(R.id.TextView04);
        tvhumidity = (TextView) this.findViewById(R.id.TextView06);
        tvTemparature_f.setText(ht.get("temp_f") + "ºF");
        tvTemparature_c.setText(ht.get("temp_c") + "ºC");
        tvhumidity.setText(ht.get("relative_humidity")+" of Humidity");
    }
}