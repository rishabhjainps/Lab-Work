package com.rj.android.resultmanagement.user;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rj.android.resultmanagement.ChangePassword;
import com.rj.android.resultmanagement.R;
import com.rj.android.resultmanagement.ViewStudentInfo;
import com.rj.android.resultmanagement.addUser;
import com.rj.android.resultmanagement.data.DbHelper;
import com.rj.android.resultmanagement.data.Provider;
import com.rj.android.resultmanagement.deleteUser;
import com.rj.android.resultmanagement.updateUser;

public class Admin extends AppCompatActivity implements USER{

    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        mOpenHelper = new DbHelper(getBaseContext());
    }

    public void changePass(View view) {
        Intent intent = new Intent(Admin.this , ChangePassword.class );
        startActivity(intent);
    }

    public void logout(View view) {
        finish();
    }


    public void reset(View view) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        db.execSQL("delete from "+ Provider.MARKS_DETAILS.TABLE_NAME);
        db.execSQL("delete from "+ Provider.LOGIN.TABLE_NAME);
        db.execSQL("delete from "+ Provider.DETAILS.TABLE_NAME);


        //ADMIN
        db.execSQL(" INSERT INTO LogIn (ID, ROLE , PASSWORD ) " +
                " VALUES ( 'ADMIN','admin','abcdef' ); ");
        db.execSQL(" INSERT INTO DETAILS (ID, NAME, EMAIL, DOB, AGE, GENDER) " +
                "VALUES ('ADMIN',' BOSS ','abc@gamil.com','29.05.1996','20','M'); ");

    }

    public void add(View view) {
        Intent intent = new Intent(Admin.this , addUser.class );
        startActivity(intent);
    }

    public void view(View view) {
        Intent intent = new Intent(Admin.this , ViewStudentInfo.class );
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent = new Intent(Admin.this , updateUser.class );
        startActivity(intent);
    }

    public void delete(View view)
    {
        Intent intent = new Intent(Admin.this , deleteUser.class );
        startActivity(intent);
    }
}
