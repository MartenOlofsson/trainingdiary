package main.namespace;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class WatchEntries extends Activity {
    /** Called when the activity is first created. */
	
	TextView text;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watchentries);
        
        
        text = (TextView) findViewById(R.id.datetext);
        
       

        
        /*Alcohol info = new Alcohol(this);
        info.open();
        String data = info.getData();
        
        
        
        info.close();
        tv.setText(data);*/
		
		DataHelper helpGetData = new DataHelper(this);
		
		helpGetData.open();
		
		
		String data = helpGetData.getData();
		
		
		text.setText(data);
		
		helpGetData.close();
		
	}
}