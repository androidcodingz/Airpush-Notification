package com.androidcodingz.airpush;

import com.airpush.android.AdCallbackListener;
import com.airpush.android.AdView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DynamicMraidAdActivity extends Activity implements AdCallbackListener.MraidCallbackListener{

	
	@SuppressLint({ "InlinedApi", "SetJavaScriptEnabled" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		RelativeLayout relativeLayout=new RelativeLayout(this);
		RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		relativeLayout.setLayoutParams(layoutParams);
		
		RelativeLayout.LayoutParams listLayoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		
		ListView view = new ListView(this);
		view.setLayoutParams(listLayoutParams);  
	    String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",  
	                                      "Jupiter", "Saturn", "Uranus", "Neptune", "Ceres","Pluto" ,"Haumea" ,"Makemake", "Eris" }; 
	    ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planets);  
	    view.setAdapter( listAdapter );
	    
	    
	    //initialize ad view
	    AdView adView=new AdView(this, AdView.BANNER_TYPE_IN_APP_AD, AdView.PLACEMENT_TYPE_INTERSTITIAL, 60, false,false, AdView.ANIMATION_TYPE_FADE );
	    adView.setId(99);
		adView.setAdListener(this);
		RelativeLayout.LayoutParams adLayoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		adLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		adLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
			
		adView.setLayoutParams(adLayoutParams);

		listLayoutParams.addRule(RelativeLayout.ABOVE, adView.getId());
		
		relativeLayout.addView(view);
		relativeLayout.addView(adView);
		setContentView(relativeLayout);
	}

	@Override
	public void onAdClickListener() 
	{
		Toast.makeText(this, "Ad Clicked", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onAdExpandedListner() 
	{
		Toast.makeText(this, "Ad Expanding", Toast.LENGTH_SHORT).show();	
		
	}

	@Override
	public void onAdLoadedListener() 
	{
		Toast.makeText(this, "Ad is loaded", Toast.LENGTH_SHORT).show();	
		
	}

	@Override
	public void onAdLoadingListener() 
	{
		Toast.makeText(this, "Ad is loading!!", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onCloseListener() 
	{
		Toast.makeText(this, "Ad Closed", Toast.LENGTH_SHORT).show();	
		
	}

	@Override
	public void onErrorListener(String arg0) 
	{
		Toast.makeText(this, "Error!! During Ad Loading", Toast.LENGTH_SHORT).show(); 
		
	}
	
}
