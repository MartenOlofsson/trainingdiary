package main.namespace;


import java.text.SimpleDateFormat;
import java.util.Date;

import main.namespace.R.id;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddRunnerEntry extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	
	String[] activityItems, timeItems;
	Spinner spinner, spinner2;
	DatePicker datepicker;
	EditText edit;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addrunnerentry);
        
       
        
        
        timeItems = new String[] {"15 min","30 min","45 min","60 min","90 min","120 min"};
        spinner2 = (Spinner) findViewById(R.id.runnerspinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, timeItems);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        
        
        edit = (EditText) findViewById(R.id.commenttext);
        
        
      
        datepicker = (DatePicker) findViewById(R.id.datePicker);
        View addButton = findViewById(R.id.addnow);
        addButton.setOnClickListener(this);

        
    }

	@Override
	public void onClick(View v) {
		
		switch(v.getId()) {
		
		case (R.id.addnow):
			
			int month  = datepicker.getMonth()+1;
		boolean ditItWork = true;
		
		try {
			
			 String activity = "Löpning";	
			 String duration = timeItems[spinner2.getSelectedItemPosition()].toLowerCase();
			 String date1 = Integer.toString(datepicker.getDayOfMonth());
			 String date2 = Integer.toString(month);	 
			 String date = date1 +"/"+date2;
			 String comment = edit.getText().toString();
			 DataHelper bengt = new DataHelper(this);
						
				bengt.open();
				bengt.createEntry(activity, date, duration, comment);
				bengt.close();

		}catch (Exception e){
			ditItWork = false;
			String error = e.getMessage();
			Dialog d = new Dialog(this);
			d.setTitle(error);
			TextView tv = new TextView(this);
			tv.setText("Fail");
			d.setContentView(tv);
			d.show();
			
			
		}finally {
			
			if(ditItWork){
				
			Dialog d = new Dialog(this);
			d.setTitle("Uppdaterat!");
			TextView tv = new TextView(this);
			tv.setText("Success");
			d.setContentView(tv);
			d.show();
			
			}
		}
		
			
		break;
		
		case (R.id.delete):
			
			//ta bort en rad i databasen
		
		
		break;
		
		}
		
		
	
		
	}
}