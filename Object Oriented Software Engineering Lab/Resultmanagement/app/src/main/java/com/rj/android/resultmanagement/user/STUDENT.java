package com.rj.android.resultmanagement.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rj.android.resultmanagement.ChangePassword;
import com.rj.android.resultmanagement.R;
import com.rj.android.resultmanagement.ViewProfile;
import com.rj.android.resultmanagement.marksDetails;

public class STUDENT extends AppCompatActivity implements USER{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    public void viewProfile(View view) {
        Intent intent = new Intent(STUDENT.this , ViewProfile.class );
        startActivity(intent);
    }

    public void viewMarks(View view) {
        Intent intent = new Intent(STUDENT.this , marksDetails.class );
        startActivity(intent);
    }

    public void changePass(View view) {
        Intent intent = new Intent(STUDENT.this , ChangePassword.class );
        startActivity(intent);
    }

    public void logout(View view) {
        finish();
    }
}
