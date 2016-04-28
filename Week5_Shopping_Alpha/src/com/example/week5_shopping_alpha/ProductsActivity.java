package com.example.week5_shopping_alpha;

import java.util.ArrayList;
import android.view.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ProductsActivity extends Activity implements View.OnClickListener{

	LinearLayout mLinear;
	ArrayList<CheckBox> mBoxes = new ArrayList<CheckBox>();
	String[] mProducts ={"A","B","C","D"};
	TextView mBudget;
	Button m_prev, m_next;
	
	int budget;
	ArrayList<String> mchoosed = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_products);
		
		mLinear = (LinearLayout) findViewById(R.id.linearContainer);
		//add check boxes to list and linear layout
		for (String  s : mProducts) {
			CheckBox check = new CheckBox(this);
			check.setText(s);
			mLinear.addView(check);
			mBoxes.add(check);
		}
		
		mBudget = (TextView) findViewById(R.id.textView1);
		
		m_next = (Button) findViewById(R.id.btnNext);
		m_prev = (Button) findViewById(R.id.btnPrevious);
		
		//both buttons have same listener
		m_next.setOnClickListener(this);
		m_prev.setOnClickListener(this);
		
		//read passed data
		Intent passed = getIntent();
		budget = passed.getIntExtra("Money", 0 /*default value if not existing*/);
		mBudget.setText("Budget="+budget);
	}

	@Override
	public void onClick(View v) {
		int buttonId =v.getId();
		
		switch(buttonId)
		{
		case R.id.btnPrevious:
			this.finish();
			break;
		case R.id.btnNext:
			int checkedCount = 0;//number of checked checkboxes
			for (CheckBox c : mBoxes) {
				if(c.isChecked()){
					checkedCount++;
					mchoosed.add(c.getText().toString());	
				}
			}
			int totalPrice = checkedCount*10;
			//Toast.makeText(this, "total price:"+totalPrice, Toast.LENGTH_LONG).show();
			//TASK TODO: display last activity with (remaining money from budy, and names for selected products displayed in linear layout of textviews
			//>>>>
			Intent i = new Intent(this,TestReport.class);
			i.putExtra("Bud", budget);
			i.putExtra("Choose", mchoosed);
			i.putExtra("TotalPrice"	, totalPrice);
			int rem =budget-totalPrice;
			i.putExtra("RemBud", rem);
			startActivity(i);
			break;
		
		}
		
	}
}
