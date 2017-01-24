package com.rj.android.resultmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.rj.android.resultmanagement.data.DbHelper;
import com.rj.android.resultmanagement.data.Provider;

import java.util.ArrayList;

public class marksDetails extends AppCompatActivity {

    ListView listview ;
    EditText sem ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_details);
        listview = (ListView)findViewById(R.id.listView);
        sem = (EditText)findViewById(R.id.ab);
        openAndQueryDatabase();
    }



    private void openAndQueryDatabase()
    {
        Log.d(" log : ", " in open query");

        ArrayList<String> results =new ArrayList<>();
        SQLiteDatabase newDB = null;
        try {
            DbHelper dbHelper = new DbHelper(this.getApplicationContext());
            newDB = dbHelper.getWritableDatabase();
            SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences("IdDetails", Context.MODE_PRIVATE);
            String idString = sharedPreferences.getString("id"," ");

            Cursor c = newDB.query(Provider.MARKS_DETAILS.TABLE_NAME , Provider.MARKS_DETAILS.Columns ," ID = ? AND SEM = ?  ", new String[]{ idString, sem.getText().toString() }, null ,null ,null  );

            Log.d(" log : ", " in open query out " + idString );

            if (c != null ) {
                Log.d(" log : ", " in open query not null  ");
                if  (c.moveToFirst()) {
                    Log.d(" log : ", " in open query moved to first ");
                    do {
                        String SUB_CODE = c.getString(c.getColumnIndex(Provider.MARKS_DETAILS.SUB_CODE));
                        int Marks = c.getInt(c.getColumnIndex(Provider.MARKS_DETAILS.MARKS));
                        results.add("        " + SUB_CODE + "               :                    " + Marks );
                        Log.d("IN OPEN DB :","        " + SUB_CODE + "           :           " + Marks);
                    }while (c.moveToNext());
                }
            }
        } catch (SQLiteException se ) {
            Log.e(getClass().getSimpleName(), "Could not create or Open the database");
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                results );

        listview.setAdapter(arrayAdapter);
        if(newDB!=null)
        newDB.close();
    }


    public void search(View view) {
        openAndQueryDatabase();
    }
}