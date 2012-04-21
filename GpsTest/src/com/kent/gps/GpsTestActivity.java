package com.kent.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GpsTestActivity extends Activity implements LocationListener {	
	private LocationManager mLocationManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        setContentView(R.layout.main);
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, this);
        TextView mTextView00 = (TextView)findViewById(R.id.TextView00);  
        mTextView00.setText("GPS Information");
    }

    @Override 
    public void onResume(){
    	if (mLocationManager != null) {
    		        
    	}               
    	super.onResume();
    }
    
    @Override    
    protected void onPause() {        
    	if (mLocationManager != null) {            
    		mLocationManager.removeUpdates((LocationListener) this);        
    	}                
    	super.onPause();    
    }  
    
    public void onLocationChanged(Location location) {        
    	TextView mTextView01 = (TextView)findViewById(R.id.TextView01);
    	TextView mTextView02 = (TextView)findViewById(R.id.TextView02);
    	TextView mTextView03 = (TextView)findViewById(R.id.TextView03);
    	TextView mTextView04 = (TextView)findViewById(R.id.TextView04);
    	TextView mTextView05 = (TextView)findViewById(R.id.TextView05);
    	TextView mTextView06 = (TextView)findViewById(R.id.TextView06);
    	TextView mTextView07 = (TextView)findViewById(R.id.TextView07);
    	mTextView01.setText("Latitude¡G  " + String.valueOf(location.getLatitude()));
    	mTextView02.setText("Longitude¡G  " + String.valueOf(location.getLongitude()));
    	mTextView03.setText("Accuracy¡G  " + String.valueOf(location.getAccuracy()));
    	mTextView04.setText("Latitude¡G  " + String.valueOf(location.getAltitude()));
    	mTextView05.setText("Time¡G  " + String.valueOf(location.getTime()));
    	mTextView06.setText("Speed¡G  " + String.valueOf(location.getSpeed()));
    	mTextView07.setText("Bearing¡G  " + String.valueOf(location.getBearing()));   
    }

    public void onProviderDisabled(String provider) {
        
    }
    public void onProviderEnabled(String provider) {
        
    }
    public void onStatusChanged(String provider, int status, Bundle extras) {
        
    }   
}