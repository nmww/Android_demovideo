package com.gongsi.activitygroup;

import android.app.Activity;
import android.os.Bundle;

public class Activity01 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.overridePendingTransition(
        		R.anim.fadein, R.anim.fadeout);
		setContentView(R.layout.main1);
		
	}
}
