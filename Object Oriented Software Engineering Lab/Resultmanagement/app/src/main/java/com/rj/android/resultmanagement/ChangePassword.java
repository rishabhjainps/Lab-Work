package com.rj.android.resultmanagement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rj.android.resultmanagement.data.DbHelper;
import com.rj.android.resultmanagement.data.Provider;

public class ChangePassword extends AppCompatActivity {

    EditText login ;
    EditText oldPassword;
    EditText newPassword;
    EditText confirmPassword;
    TextView label;
    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        login = (EditText)findViewById(R.id.loginid);
        oldPassword = (EditText)findViewById(R.id.email);
        newPassword = (EditText)findViewById(R.id.dob);
        confirmPassword = (EditText)findViewById(R.id.confirmPass);
        label = (TextView)findViewById(R.id.Label);

        mOpenHelper = new DbHelper(getBaseContext());
    }


    public void submit(View view) {

        String idText = login.getText().toString();
        String passText = oldPassword.getText().toString();
        String passTextnew = newPassword.getText().toString();
        String passTextNewC = confirmPassword.getText().toString();

        if(idText.length()==0 || passText.length()==0 )
        {
            label.setText(" ID OR PASSWORD IS EMPTY  ");
        }else if(idText.length()<4 || passText.length()<4||idText.length()>20 || passText.length()>20)
        {
            label.setText(" ID OR PASSWORD IS NOT OF APPROPRIATE LENGTH  ");
        }else if( passTextnew.length()<4 || passTextnew.length()>20)
        {
            label.setText(" NEW PASSWORD IS NOT OF APPROPRIATE LENGTH  ");
        }else if( !passTextnew .equals( passTextNewC) )
        {
            label.setText(" NEW PASSWORD AND CONFIRM PASSWORD DO NOT MATCH ");
        }else
        {
            SQLiteDatabase db = mOpenHelper.getWritableDatabase();
            Cursor c = db.query(Provider.LOGIN.TABLE_NAME , Provider.LOGIN.Columns ," ID = ?  ", new String[]{ idText }, null ,null ,null  );

            if(c.moveToFirst() && c.getString(c.getColumnIndex("PASSWORD")).equals(oldPassword.getText().toString())){
                label.setText(" LOGIN SUCCESS ");
                ContentValues cv =new ContentValues();
                cv.put(Provider.LOGIN.PASSWORD,passTextnew);
                db.update(Provider.LOGIN.TABLE_NAME , cv , " ID = ? " ,new String[]{idText});
                label.setText(" UPDATE SUCCESSFULL ");
            }else{
                label.setText(" LOGIN FAILED PASSWORD NOT MATCHED ");
            }
            db.close();
        }

    }

    public void cancel(View view) {
        finish();
    }
}

