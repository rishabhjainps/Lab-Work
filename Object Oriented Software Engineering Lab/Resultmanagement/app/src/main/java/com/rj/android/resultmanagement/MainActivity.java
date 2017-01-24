package com.rj.android.resultmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rj.android.resultmanagement.data.DbHelper;
import com.rj.android.resultmanagement.data.Provider;
import com.rj.android.resultmanagement.user.Admin;
import com.rj.android.resultmanagement.user.DEO;
import com.rj.android.resultmanagement.user.FACULTY;
import com.rj.android.resultmanagement.user.STUDENT;

public class MainActivity extends AppCompatActivity {

    TextView label ;
    EditText id ;
    EditText passwrd ;


    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOpenHelper = new DbHelper(getBaseContext());


        label = (TextView)findViewById(R.id.Label);
        id = (EditText)findViewById(R.id.id);
        passwrd = (EditText)findViewById(R.id.passwrd);
        label.setText(" ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        label.setText(" ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        label.setText(" ");
    }

    public void forgotPassword(View v)
    {
        Intent intent = new Intent(MainActivity.this , ForgotActivity.class);
        startActivity(intent);
    }


    public void login(View view)
    {
        String idText = id.getText().toString();
        String passText = passwrd.getText().toString();
        if(idText.length()==0 || passText.length()==0 )
        {
            label.setText(" ID OR PASSWORD IS EMPTY  ");
        }else if(idText.length()<4 || passText.length()<4||idText.length()>20 || passText.length()>20)
        {
            label.setText(" ID OR PASSWORD IS NOT OF APPROPRIATE LENGTH  ");
        }else
        {
            SQLiteDatabase db = mOpenHelper.getWritableDatabase();
            try{
                Cursor c = db.query(Provider.LOGIN.TABLE_NAME , Provider.LOGIN.Columns ," ID = ?  ", new String[]{ idText }, null ,null ,null  );


                if(c.moveToFirst() && c.getString(2).equals( passwrd.getText().toString() )  ){
                    label.setText(" LOGIN SUCCESS ");
                    db.close();
                    seeAccess(idText , c.getString(1));
                }else{
                    label.setText(" LOGIN FAILED WRONG PASSWORD ");
                }
            }catch( Exception e){
                label.setText(" LOGIN FAILED ");
                Log.d(" LOG ::" , e.getMessage());
            }
        }

    }

    private void seeAccess(String idText , String role)
    {

        SharedPreferences sharedPreferences = getSharedPreferences("IdDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id", idText);
        editor.commit();
        Intent intent = null ;
        switch (role)
        {
            case "admin":
                intent = new Intent(this , Admin.class );
                startActivity(intent);
                break;
            case "deo":
                intent = new Intent(this , DEO.class );
                startActivity(intent);
                break;
            case "faculty":
                intent = new Intent(this , FACULTY.class );
                startActivity(intent);
                break;
            case "student":
                intent = new Intent(this , STUDENT.class );
                startActivity(intent);
                break;
            default:label.setText("ROLE NOT FOUND");
        }
    }
}
