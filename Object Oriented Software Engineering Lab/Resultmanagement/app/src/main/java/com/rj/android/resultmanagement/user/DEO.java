package com.rj.android.resultmanagement.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rj.android.resultmanagement.ChangePassword;
import com.rj.android.resultmanagement.R;
import com.rj.android.resultmanagement.ViewProfile;
import com.rj.android.resultmanagement.ViewStudentInfo;
import com.rj.android.resultmanagement.addMarks;
import com.rj.android.resultmanagement.addUser;
import com.rj.android.resultmanagement.deleteUser;
import com.rj.android.resultmanagement.updateMarks;
import com.rj.android.resultmanagement.updateUser;

public class DEO extends AppCompatActivity implements USER {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deo);
    }

    public void changePass(View view) {
        Intent intent = new Intent(DEO.this , ChangePassword.class );
        startActivity(intent);
    }

    public void logout(View view) {
        finish();
    }

    public void updateMarks(View view) {
        Intent intent = new Intent(DEO.this , updateMarks.class );
        startActivity(intent);
    }

    public void view(View view) {
        Intent intent = new Intent(DEO.this , ViewStudentInfo.class );
        startActivity(intent);
    }

    public void addResult(View view) {
        Intent intent = new Intent(DEO.this , addMarks.class );
        startActivity(intent);
    }

    public void add(View view) {
        Intent intent = new Intent(DEO.this , addUser.class );
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent = new Intent(DEO.this , updateUser.class );
        startActivity(intent);
    }

    public void delete(View view)
    {
        Intent intent = new Intent(DEO.this , deleteUser.class );
        startActivity(intent);
    }
}
