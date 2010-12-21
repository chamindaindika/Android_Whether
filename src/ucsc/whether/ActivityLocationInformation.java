package ucsc.whether;

import java.util.HashMap;
import java.util.Hashtable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityLocationInformation extends Activity {	
	TextView tvFull;
	TextView tvCity;
	TextView tvState;
	TextView tvStateName;
	TextView tvCountry;
	TextView tvCountryISO;
	TextView tvZip;
	TextView tvLatitude;
	TextView tvLongitude;
	TextView tvElevation;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_locationinfo);
        
        @SuppressWarnings("unchecked")
		HashMap<String, String> ht = (HashMap<String, String>) getIntent().getSerializableExtra("hash");
    
        tvFull = (TextView) this.findViewById(R.id.TextView03);
        tvCity = (TextView) this.findViewById(R.id.TextView05);
        tvState = (TextView) this.findViewById(R.id.TextView07);
        tvStateName = (TextView) this.findViewById(R.id.TextView09);
        tvCountry = (TextView) this.findViewById(R.id.TextView11);
        tvCountryISO = (TextView) this.findViewById(R.id.TextView13);
        tvZip = (TextView) this.findViewById(R.id.TextView15);
        tvLatitude = (TextView) this.findViewById(R.id.TextView17);
        tvLongitude = (TextView) this.findViewById(R.id.TextView19);
        tvElevation = (TextView) this.findViewById(R.id.TextView21);
        
        tvFull.setText(ht.get("full"));
        tvCity.setText(ht.get("city"));
        tvState.setText(ht.get("state"));
        tvStateName.setText(ht.get("state_name"));
        tvCountry.setText(ht.get("country"));
        tvCountryISO.setText(ht.get("country_iso3166"));
        tvZip.setText(ht.get("zip"));
        tvLatitude.setText(ht.get("latitude"));
        tvLongitude.setText(ht.get("longitude"));
        tvElevation.setText(ht.get("elevation"));
        
    }
}