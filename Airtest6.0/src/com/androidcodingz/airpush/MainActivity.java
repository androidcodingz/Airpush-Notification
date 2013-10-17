package com.androidcodingz.airpush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airpush.android.AdCallbackListener;
import com.airpush.android.Airpush;

public class MainActivity extends Activity implements View.OnClickListener, AdCallbackListener {
	Airpush airpush;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findViewById(R.id.mraidDemo).setOnClickListener(this);
		findViewById(R.id.mraidDemoDynamic).setOnClickListener(this);
		
		Airpush.setOptinListener(listener);
		if(airpush==null)
			airpush=new Airpush(getApplicationContext(), this);
		//starting Push Notification Ad in test mode. 
		airpush.startPushNotification(true);
		//starting Icon Ad
		airpush.startIconAd();	
		
	}
@Override
protected void onStart() {
	super.onStart();
	//starting SmartWall Ad
	if(airpush!=null)
	airpush.startSmartWallAd();

}	
	
public void onClick(View v) {
switch (v.getId()) {
case R.id.mraidDemo:

	//show rich media ad while changing Activity. 
	if(airpush!=null)
	airpush.showRichMediaInterstitialAd();
	startActivity(new Intent(MainActivity.this, MraidAdActivity.class));
	break;
case R.id.mraidDemoDynamic:
	startActivity(new Intent(MainActivity.this, DynamicMraidAdActivity.class));
	break;

default:
	break;
}	
	
}

	OptinListener listener=new OptinListener() {
		
		@Override
		public void showingDialog() {
		//This will get called when EULA dialog is showing. User will not be able to access the screen.  
			Toast.makeText(MainActivity.this, "EULA dialog is showing...", Toast.LENGTH_SHORT).show();	
		}
		
		@Override
		public void optinResult(boolean arg0) {
		//This will get called when EULA dialog is closed.
			if(arg0)
			Toast.makeText(MainActivity.this, "You have accepted the EULA.", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(MainActivity.this, "You have not accepted the EULA.", Toast.LENGTH_SHORT).show();
		}
	};
	
	@Override
	public void onSDKIntegrationError(String arg0) {
		/*
		 * This method will get called by SDK when it detects any integration issue. 
		 */
	Toast.makeText(this, "Airpush SDK integartion issue: "+arg0, Toast.LENGTH_SHORT).show();	
	}

	
	@Override
	public void onAdError(String arg0) {
		/* This method will get called by SDK when any issue is occurred while ad is serving. You may receive some other error messages. 
		 */
		Toast.makeText(this, "AD issue: "+arg0, Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onSmartWallAdShowing() {

		/*
		 * This method will get called by SDK when SmartWall ad is showing. 
		 */
		Toast.makeText(this, "SmartWall Ad is showing.", Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onSmartWallAdClosed() {
		/*
		 * This method will get called by SDK when SmartWall ad is closed. 
		 */
		Toast.makeText(this, "SmartWall closed.", Toast.LENGTH_SHORT).show();	
	}

	

}
