package com.example.week5_shopping_alpha;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestReport extends Activity {

	LinearLayout mLinear;
	TextView mTotalBud,mTotalPrice,mRemBud;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_report);
		mLinear = (LinearLayout)findViewById(R.id.containerAll);
		mTotalBud = (TextView)findViewById(R.id.txt_TotalBudg);
		mTotalPrice = (TextView)findViewById(R.id.txt_TotalPrice);
		mRemBud = (TextView)findViewById(R.id.txt_RemBudget);
		
		Intent passed = getIntent();
		ArrayList<String> mchoosed = passed.getStringArrayListExtra("Choose");
		for (String  s : mchoosed) {
			TextView tex = new TextView(this);
			tex.setText(s);
			mLinear.addView(tex);
		}
		int budget= passed.getIntExtra("Bud", 0);
		mTotalBud.setText(budget+"");
		int totalPr = passed.getIntExtra("TotalPrice", 0);
		mTotalPrice.setText(totalPr+"");
		int remBud = passed.getIntExtra("RemBud", 0);
		mRemBud.setText(remBud+"");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test_report, menu);
		return true;
	}

}
