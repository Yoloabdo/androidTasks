package com.example.task1;

import java.security.spec.MGF1ParameterSpec;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView mIndex;
	TextView mText;
	Button mOk;
	Button mNxt;
	Button mPrv;
	RadioGroup mRG;
	RadioButton r0;
	RadioButton r1;
	RadioButton r2;
	ImageView mimg;
	Q [] Questions= new Q[5];
	int index=1;
	void showMessage(String m)
	{
		Toast.makeText(this, m, Toast.LENGTH_LONG).show();
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mIndex=(TextView)findViewById(R.id.lblIndex);
        mText = (TextView)findViewById(R.id.lblQuestion);
        mOk=(Button)findViewById(R.id.btnOk);
        mNxt=(Button)findViewById(R.id.btnNxt);
        mPrv=(Button)findViewById(R.id.btnPrev);
        mRG=(RadioGroup)findViewById(R.id.goOptions);
        r0=(RadioButton)findViewById(R.id.radio0);
        r1=(RadioButton)findViewById(R.id.radio1);
        r2=(RadioButton)findViewById(R.id.radio2);
        mimg=(ImageView)findViewById(R.id.img);
        
        //create questions and add them to array
        final Q q1= new Q("What is the os?",new String[]{"WP","Andoriod","ios"},1);
        final Q q2= new Q("2 + 2 = ",new String[]{"4","5","3"},0);
        final Q q3= new Q("We are in ?",new String[]{"USA","UK","EGY"},2);
        final Q q4= new Q("Binary Use ?",new String[]{"1 only","0 only","Both"},2);
        final Q q5= new Q("The newst version of Windows?",new String[]{"W8.1","W10","W12"},1);
        Questions[0]=q1;
        Questions[1]=q2;
        Questions[2]=q3;
        Questions[3]=q4;
        Questions[4]=q5;
        //--------------------------------------
        mRG.clearCheck();
        getQuestion();
        //--------------------------------------
        
        mOk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int Answer = mRG.getCheckedRadioButtonId();
				if(Answer==-1)
				{
					showMessage("Error Choose an answer You fool!!");
					//mimg.setImageResource(R.drawable.wrong);
				}
				else
				{
					RadioButton t = (RadioButton)findViewById(Answer);
					if(Questions[index-1].IsCorrect(t.getText().toString()))
					{
						showMessage("Correct ");
						mimg.setImageResource(R.drawable.correct);
					}
					else{showMessage("Wrong ");
					mimg.setImageResource(R.drawable.wrong);
					}
				}
				
			}
		});
        mNxt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				if(index<5)
				{
				index++;
				mimg.setImageDrawable(null);
				mRG.clearCheck();
				getQuestion();
				}
				else
				{
					showMessage("This is the last One Dude!!");
				}
			}
		});
        mPrv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				if(index>1)
				{
					index--;
					mimg.setImageDrawable(null);
					getQuestion();
					}
				else
				{
						showMessage("This is the first One Dude!!");
				}
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void getQuestion() {
    	
    	// put question according to index
    	mIndex.setText(Integer.toString(index));
        mText.setText(Questions[index-1].Text);
        r0.setText(Questions[index-1].Options[0]);
        r1.setText(Questions[index-1].Options[1]);
        r2.setText(Questions[index-1].Options[2]);
	}
}
