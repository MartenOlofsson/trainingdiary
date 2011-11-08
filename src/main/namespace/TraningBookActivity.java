package main.namespace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class TraningBookActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        View lookButton = findViewById(R.id.look);
        lookButton.setOnClickListener(this);
        View cycleButton = findViewById(R.id.bikebutton);
        cycleButton.setOnClickListener(this);
        View gymButton = findViewById(R.id.gymbutton);
        gymButton.setOnClickListener(this);
        View kajakButton = findViewById(R.id.kajakbutton);
        kajakButton.setOnClickListener(this);
        View runnerButton = findViewById(R.id.runbutton);
        runnerButton.setOnClickListener(this);
        
    }
    
 

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		
		case(R.id.look):
			
			Intent j =new Intent(TraningBookActivity.this, WatchEntries.class);
			startActivity(j);
			
			break;
			
		case(R.id.bikebutton):
			
			Intent e = new Intent(TraningBookActivity.this, AddCycleEntry.class);
		
		startActivity(e);
		
		break;
		
		case(R.id.gymbutton):
			
			Intent b = new Intent(TraningBookActivity.this, AddEntry.class);
		
		startActivity(b);
		
		break;
		case(R.id.runbutton):
			
			Intent k = new Intent(TraningBookActivity.this, AddRunnerEntry.class);
		
		startActivity(k);
		
		break;
		case(R.id.kajakbutton):
	
			Intent o = new Intent(TraningBookActivity.this, AddKajakEntry.class);

		startActivity(o);
	
		break;
		
		//case exit
		
		}
		
		
		
	}
}