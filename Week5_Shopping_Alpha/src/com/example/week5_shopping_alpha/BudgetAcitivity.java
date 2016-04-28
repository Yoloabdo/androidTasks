package com.example.week5_shopping_alpha;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class BudgetAcitivity extends Activity implements OnClickListener{

	EditText mInput;
	Button mNext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_budget_acitivity);
		
		mInput = (EditText) findViewById(R.id.txtBudget);
		mNext = (Button) findViewById(R.id.btnBudgetNext);
		mNext.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.budget_acitivity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		try{
			int val = Integer.parseInt(mInput.getText().toString());
			//if no exception then continue normally
			
			if(val<=0)
				Toast.makeText(this, "No zero/Negative Allowed", Toast.LENGTH_LONG).show();
			else
			{
				//start 3rd activity and pass budget to it
				Intent productsIntent = new Intent(this, ProductsActivity.class);
				productsIntent.putExtra("Money", val);
				startActivity(productsIntent);
			}
		}
		catch(Exception e)
		{
			Toast.makeText(this, "invalid number format", Toast.LENGTH_LONG).show();
		}
	}
}
