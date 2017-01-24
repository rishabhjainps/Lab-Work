package com.rj.android.resultmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotActivity extends AppCompatActivity {

    EditText login;
    EditText email ;
    EditText  dob ;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        login = (EditText)findViewById(R.id.loginid);
        email = (EditText)findViewById(R.id.email);
        dob = (EditText)findViewById(R.id.dob);
        label = (TextView)findViewById(R.id.Label);
    }

    public void submit(View v)
    {
        Intent Email = new Intent(Intent.ACTION_SEND);
        Email.setType("text/email");
        Email.putExtra(Intent.EXTRA_EMAIL, new String[] { "rishabhjainps2@gmail.com" });
        Email.putExtra(Intent.EXTRA_SUBJECT, " CHANGE PASSWORD REQUEST ");
        Email.putExtra(Intent.EXTRA_TEXT, " Hello ADMIN ," + "\n LOG IN ID :"+ login.getText().toString()
                            +"\n EMAIL ID :" + email.getText().toString()
                            + "\n DOB : " + dob.getText().toString() );
        startActivity(Intent.createChooser(Email, " Send REQUEST :"));
    }

    public void cancel(View v)
    {
        finish();
    }

}