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

public class deleteUser extends AppCompatActivity {

    EditText id ;
    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        id = (EditText)findViewById(R.id.id);
    }

    public void submit(View view)
    {

        if(id.getText().toString().length()<4 || id.getText().toString().length()>20 ) {
            Toast.makeText(getBaseContext(), "id NOT VALID ", Toast.LENGTH_SHORT).show();
            return;
        }


        mOpenHelper = new DbHelper(getBaseContext());
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        ContentValues cv =  new ContentValues();
        ContentValues cv2 =  new ContentValues();
        cv.put(Provider.DETAILS.id , id.getText().toString());

        cv2.put(Provider.LOGIN.id , id.getText().toString());


        try {
            int i = db.delete(Provider.DETAILS.TABLE_NAME, " ID = ?  ", new String[]{id.getText().toString()});
            db.delete(Provider.LOGIN.TABLE_NAME, " ID = ?  ", new String[]{id.getText().toString()});
            if (i != 0)
                Toast.makeText(getBaseContext(), " DELETE SUCCESSFULL ", Toast.LENGTH_SHORT).show();
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
