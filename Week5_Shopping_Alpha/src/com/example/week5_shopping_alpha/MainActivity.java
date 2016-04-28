package com.example.week5_shopping_alpha;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button)findViewById(R.id.button_start);
        b.setOnClickListener(this);
    }
//... other methods
//the other 2 methods could be ignored currently

	public void onClick(View v) {
		Intent i = new Intent(this, BudgetAcitivity.class);
		startActivity(i);
	}
}
