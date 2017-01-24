package com.rj.android.resultmanagement;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rj.android.resultmanagement.data.DbHelper;
import com.rj.android.resultmanagement.data.Provider;

public class ViewStudentInfo extends AppCompatActivity {


    TextView name ;
    TextView id ;
    TextView email ;
    TextView dob ;
    TextView age ;
    TextView gender ;
    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_info);
    }

    public void check(View view) {

        String idString = ((EditText)findViewById(R.id.enterroll)).getText().toString();
        Log.d("View PRofile : " , idString );
        mOpenHelper = new DbHelper(getBaseContext());
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        Cursor c = db.query(Provider.DETAILS.TABLE_NAME , Provider.DETAILS.Columns ," ID = ?  ", new String[]{ idString }, null ,null ,null  );

        name = (TextView)findViewById(R.id.name);
        id = (TextView)findViewById(R.id.id);
        email = (TextView)findViewById(R.id.email);
        dob = (TextView)findViewById(R.id.dob);
        age = (TextView)findViewById(R.id.age);
        gender = (TextView)findViewById(R.id.gender);

        if(c.moveToFirst())
        {
            name.setText( " " + c.getString(c.getColumnIndex(Provider.DETAILS.NAME)) );
            id.setText( " " + c.getString(c.getColumnIndex(Provider.DETAILS.id)) );
            email.setText( " " + c.getString(c.getColumnIndex(Provider.DETAILS.EMAIL)) );
            dob.setText( " " + c.getString(c.getColumnIndex(Provider.DETAILS.DOB)) );
            age.setText( " " + c.getInt(c.getColumnIndex(Provider.DETAILS.AGE)) );
            gender.setText( " " + c.getString(c.getColumnIndex(Provider.DETAILS.GENDER)) );
        }else {
            Toast.makeText(getBaseContext() , " ROLL NO. NOT FOUND ",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}