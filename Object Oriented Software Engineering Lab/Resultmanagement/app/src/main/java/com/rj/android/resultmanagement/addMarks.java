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

public class addMarks extends AppCompatActivity {



    EditText rollNo ;
    EditText subjectCode ;
    EditText marks ;
    TextView label ;
    TextView sem ;

    private DbHelper mOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marks);
        rollNo = (EditText)findViewById(R.id.rollNo);
        subjectCode = (EditText)findViewById(R.id.subjectCode);
        marks = (EditText)findViewById(R.id.marks);
        label = (TextView)findViewById(R.id.Label);
        sem = (TextView)findViewById(R.id.sem);
        mOpenHelper = new DbHelper(getBaseContext());
    }

    public void update(View view)
    {
        String rollNoString = rollNo.getText().toString();
        String subjectCodeString = subjectCode.getText().toString();
        int markInt = new Integer( marks.getText().toString() );

        if(rollNoString.length()==0 || subjectCode.length()==0 )
        {
            label.setText(" ROLL NO OR SUBJECT CODE IS EMPTY  ");
        }else if(rollNoString.length()<4 || subjectCode.length()<4||rollNoString.length()>20 || subjectCode.length()>7)
        {
            label.setText(" ROLL NO OR SUBJECT CODE IS NOT OF APPROPRIATE LENGTH  ");
        }else if( markInt <0 || markInt >100 )
        {
            label.setText(" MARKS ENETERED ARE NOT IN GIVEN RANGE  ");
        }else{
            try {
                SQLiteDatabase db = mOpenHelper.getWritableDatabase();
                Cursor c = db.query(Provider.MARKS_DETAILS.TABLE_NAME, Provider.MARKS_DETAILS.Columns, " ID = ? AND SUB_CODE = ? ", new String[]{rollNoString,subjectCodeString}, null, null, null);

                if (!c.moveToFirst()) {
                    label.setText(" ROLL NO EXITS ");
                    ContentValues cv = new ContentValues();
                    cv.put(Provider.MARKS_DETAILS.id,rollNoString);
                    cv.put(Provider.MARKS_DETAILS.MARKS, markInt);
                    cv.put(Provider.MARKS_DETAILS.SEM , sem.getText().toString());
                    cv.put(Provider.MARKS_DETAILS.SUB_CODE,subjectCodeString);

                    int i = (int) db.insert(Provider.MARKS_DETAILS.TABLE_NAME ,null , cv );

                    if (i >=0 )
                        label.setText(" ADD SUCCESSFULL " + String.valueOf(i));
                    else
                        label.setText(" NOT INSERTED " + String.valueOf(i));
                } else {
                    label.setText(" ENTERED MARKS ALREADY PRESENT TRY UPDATE ");
                }
                db.close();
            }catch (Exception e)
            {
                label.setText(" ENTERED DATA NOT MATCHED ");
            }
        }
    }

    public void cancel(View view)
    {
        finish();
    }

}
