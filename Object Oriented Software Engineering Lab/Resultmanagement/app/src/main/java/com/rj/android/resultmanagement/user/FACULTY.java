package com.rj.android.resultmanagement.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rj.android.resultmanagement.ChangePassword;
import com.rj.android.resultmanagement.R;
import com.rj.android.resultmanagement.ViewProfile;
import com.rj.android.resultmanagement.ViewStudentInfo;
import com.rj.android.resultmanagement.marksDetails;
import com.rj.android.resultmanagement.updateMarks;

public class FACULTY extends AppCompatActivity implements USER{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
    }

    public void viewProfile(View view) {
        Intent intent = new Intent(FACULTY.this , ViewProfile.class );
        startActivity(intent);
    }

    public void changePass(View view) {
        Intent intent = new Intent(FACULTY.this , ChangePassword.class );
        startActivity(intent);
    }

    public void logout(View view) {
        finish();
    }

    public void updateMarks(View view) {
        Intent intent = new Intent(FACULTY.this , updateMarks.class );
        startActivity(intent);
    }

    public void viewStudentInfo(View view) {
        Intent intent = new Intent(FACULTY.this , ViewStudentInfo.class );
        startActivity(intent);
    }

}
