package mans.section5;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mList = (ListView)findViewById(R.id.lvNames);
        final String[] names={"5","9","1","52","2"
        		,"8","3","2","45","12","10"
        		,"6","7"};
        mList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<String> adaptor = new ArrayAdapter<String>
        (this,android.R.layout.simple_list_item_checked,names);
        mList.setAdapter(adaptor);
        
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				/*Toast.makeText(MainActivity.this, "item "+names[position],
						Toast.LENGTH_SHORT).show();*/
				SparseBooleanArray selected = mList.getCheckedItemPositions();
				int count =0;
				for (int i = 0; i < names.length; i++) {
					if (selected.get(i)) {
						count +=Integer.parseInt( mList.getItemAtPosition(i).toString());
						 
					}					
				}
				
				Toast.makeText(MainActivity.this, "#  "+count,
						Toast.LENGTH_SHORT).show();
			}
		}); {
			
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
