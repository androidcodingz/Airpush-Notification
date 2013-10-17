package com.androidcodingz.airpush;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.airpush.android.AdCallbackListener;
import com.airpush.android.AdView;

public class MraidAdActivity extends Activity implements AdCallbackListener.MraidCallbackListener{

	
	@SuppressLint({ "InlinedApi", "SetJavaScriptEnabled" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		AdView adView=(AdView)findViewById(R.id.myAdview);
		adView.setAdListener(this);
		
		WebView view=(WebView)findViewById(R.id.adWebView);
		view.getSettings().setJavaScriptEnabled(true);
		view.loadUrl("http://m.airpush.com/");
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
