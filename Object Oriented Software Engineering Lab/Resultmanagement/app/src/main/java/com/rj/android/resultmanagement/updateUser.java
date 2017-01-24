package com.rj.android.resultmanagement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rj.android.resultmanagement.data.DbHelper;
import com.rj.android.resultmanagement.data.Provider;

public class updateUser extends AppCompatActivity {


    EditText name ;
    EditText id ;
    EditText email ;
    EditText dob ;
    EditText age ;
    EditText gender ;
    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        name = (EditText)findViewById(R.id.name);
        id = (EditText)findViewById(R.id.id);
        email = (EditText)findViewById(R.id.email);
        dob = (EditText)findViewById(R.id.dob);
        age = (EditText)findViewById(R.id.age);
        gender = (EditText)findViewById(R.id.gender);

    }

    public void submit(View view) {




        if(name.getText().toString().length()<4 || name.getText().toString().length()>20 ) {
            Toast.makeText(getBaseContext(), "NAME NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(id.getText().toString().length()<4 || id.getText().toString().length()>20 ) {
            Toast.makeText(getBaseContext(), "id NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(email.getText().toString().length()<4 || email.getText().toString().length()>20 ) {
            Toast.makeText(getBaseContext(), "email NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(dob.getText().toString().length()==10 ) {
            Toast.makeText(getBaseContext(), "dob NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(gender.getText().toString().length()==1 ) {
            Toast.makeText(getBaseContext(), " Gender NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }
        int ageValue = Integer.parseInt(age.getText().toString());
        if( ageValue < 0 || ageValue >100 ) {
            Toast.makeText(getBaseContext(), " AGE NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }

        mOpenHelper = new DbHelper(getBaseContext());
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Provider.DETAILS.id, id.getText().toString());
        cv.put(Provider.DETAILS.NAME, name.getText().toString());
        cv.put(Provider.DETAILS.AGE, age.getText().toString());
        cv.put(Provider.DETAILS.EMAIL, email.getText().toString());
        cv.put(Provider.DETAILS.DOB, dob.getText().toString());
        cv.put(Provider.DETAILS.GENDER, gender.getText().toString());

        try {
            int i = db.update(Provider.DETAILS.TABLE_NAME, cv, " ID = ?  ", new String[]{id.getText().toString()});
            if (i != 0)
                Toast.makeText(getBaseContext(), " UPDATE SUCCESSFULL ", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getBaseContext(), " UN SUCCESSFULL ", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), " UN SUCCESSFULL ", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancel(View view)
    {
        finish();
    }
}
