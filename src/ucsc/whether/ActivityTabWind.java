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
    
        //tvWind = (TextView) this.findViewById(R.id.TextView02);
        tvDir = (TextView) this.findViewById(R.id.TextView04);
        tvDegree = (TextView) this.findViewById(R.id.TextView06);
        tvSpeed = (TextView) this.findViewById(R.id.TextView08);
        //tvWind.setText(ht.get("wind_string"));
        tvDir.setText(ht.get("wind_dir"));
        tvDegree.setText(ht.get("wind_degrees")+ "º");
        tvSpeed.setText(ht.get("wind_mph")+" mph");
    }
}