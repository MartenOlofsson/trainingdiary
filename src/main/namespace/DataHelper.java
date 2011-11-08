package main.namespace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper {
	
	
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "training_name";
	public static final String KEY_TIME = "training_time";
	public static final String KEY_DATE = "training_date";
	public static final String KEY_COMMENT = "training_comment";


	
	private static final String DATABASE_NAME = "TrainingDb";
	private static final String DATABASE_TABLE = "TrainingTable";
	private static final int  DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	public static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " + 
					KEY_DATE + " TEXT NOT NULL, " + 
					KEY_COMMENT + " TEXT NOT NULL, " + 
					KEY_TIME + " TEXT NOT NULL);"	
					);
			
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
		}
		
		
	}
	
	public DataHelper (Context c) {
		
		ourContext = c;
	}
	
	public DataHelper open() throws SQLException{
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
		
	}
	
	public void close(){
		
		ourHelper.close();
	}

	public long createEntry(String activity, String date, String duration, String comment) {
		
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, activity);
		cv.put(KEY_TIME, duration);
		cv.put(KEY_DATE, date);
		cv.put(KEY_COMMENT, comment);
			
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
		
		//http://www.youtube.com/watch?v=HRId7kvLyJk&feature=relmfu
		
	}

	public String getData() {
		
		String[] columns = new String[] {KEY_ROWID, KEY_NAME, KEY_TIME, KEY_DATE, KEY_COMMENT};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int IRow = c.getColumnIndex(KEY_ROWID);
		int IName = c.getColumnIndex(KEY_NAME);
		int ITime = c.getColumnIndex(KEY_TIME);
		int IDate = c.getColumnIndex(KEY_DATE);
		int IComment = c.getColumnIndex(KEY_COMMENT);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			
			result =  result + c.getString(IDate) + " - " + c.getString(IName)+ " " + c.getString(ITime) +" ("+ c.getString(IComment)+")" + "\n";                  
		}
		
		return result;
	}

	public void deleteEntry(int row) {
		
		int loop = 100;
		
		for(int i =0; i<loop; i++){
			
			ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + i, null);
			
			
			
		}
		
		
		
		 
		
	}
 
}