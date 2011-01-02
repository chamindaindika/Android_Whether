package ucsc.whether;

import java.util.HashMap;

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
	TextView tvFull1;
	TextView tvCity1;
	TextView tvState1;	
	TextView tvCountry1;
	TextView tvCountryISO1;	
	TextView tvLatitude1;
	TextView tvLongitude1;	
	TextView tvElevation1;
	
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
        
        if(ht.get("full").length()>2){
        	tvFull.setText(ht.get("full"));
        }else{
        	tvFull.setText("N/A");
        }
        if(ht.get("city").length()>0){
        	tvCity.setText(ht.get("city"));
        }else{
        	tvCity.setText("N/A");
        }
        if(ht.get("state").length()>0){
        	System.out.println("aaaaa"+ht.get("state").length());
        	tvState.setText(ht.get("state"));
        }else{
        	tvState.setText("N/A");
        }
        if(ht.get("state_name").length()>0){
        	tvStateName.setText(ht.get("state_name"));
        }else{
        	tvState.setText("N/A");
        }
        if(ht.get("country").length()>0){
        	tvCountry.setText(ht.get("country"));
        }else{
        	tvCountry.setText("N/A");
        }
        if(ht.get("country_iso3166").length()>0){
        	tvCountryISO.setText(ht.get("country_iso3166"));
        }else{
        	tvCountryISO.setText("N/A");
        }
        if(ht.get("zip").length()>0){
        	tvZip.setText(ht.get("zip"));
        }else{
        	tvZip.setText("N/A");
        }
        if(ht.get("latitude").length()>0){
        	tvLatitude.setText(ht.get("latitude"));
        }else{
        	tvLatitude.setText("N/A");
        }
        if(ht.get("longitude").length()>0){
        	tvLongitude.setText(ht.get("longitude"));
        }else{
        	tvLongitude.setText("N/A");
        }
        if(ht.get("elevation").length()>3){  	
        	tvElevation.setText(ht.get("elevation"));        	
        }else{
        	tvElevation.setText("N/A");
        }
        
        tvFull1 = (TextView) this.findViewById(R.id.TextView25);
        tvCity1 = (TextView) this.findViewById(R.id.TextView27);
        tvState1 = (TextView) this.findViewById(R.id.TextView29);        
        tvCountry1 = (TextView) this.findViewById(R.id.TextView31);
        tvCountryISO1 = (TextView) this.findViewById(R.id.TextView33);        
        tvLatitude1 = (TextView) this.findViewById(R.id.TextView35);
        tvLongitude1 = (TextView) this.findViewById(R.id.TextView37); 
        tvElevation1 = (TextView) this.findViewById(R.id.TextView39);
        
        if(ht.get("obfull").length()>2){
        	tvFull1.setText(ht.get("obfull"));
        }else{
        	tvFull1.setText("N/A");
        }
        if(ht.get("obcity").length()>0){
        	tvCity1.setText(ht.get("obcity"));
        }else{
        	tvCity1.setText("N/A");
        }
        if(ht.get("obstate").length()>0){
        	tvState1.setText(ht.get("obstate")); 
        }else{
        	tvState1.setText("N/A");
        }
        if(ht.get("obcountry").length()>0){
        	tvCountry1.setText(ht.get("obcountry"));
        }else{
        	tvCountry1.setText("N/A");
        }
        if(ht.get("obcountry_iso3166").length()>0){
        	tvCountryISO1.setText(ht.get("obcountry_iso3166"));  
        }else{
        	tvCountryISO1.setText("N/A");
        }
        if(ht.get("oblatitude").length()>0){
        	tvLatitude1.setText(ht.get("oblatitude"));
        }else{
        	tvLatitude1.setText("N/A");
        }
        if(ht.get("oblongitude").length()>0){
        	tvLongitude1.setText(ht.get("oblongitude"));
        }else{
        	tvLongitude1.setText("N/A");
        }
        if(ht.get("obelevation").length()>3){
        	tvElevation1.setText(ht.get("obelevation"));
        }else{
        	tvElevation1.setText("N/A");
        }
        
        
    }
}