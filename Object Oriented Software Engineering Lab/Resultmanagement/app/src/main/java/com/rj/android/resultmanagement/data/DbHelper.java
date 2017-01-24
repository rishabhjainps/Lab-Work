package com.rj.android.resultmanagement.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper extends SQLiteOpenHelper {


    private static final String LOG_TAG = SQLiteDatabase.class.getSimpleName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME="login.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          final String SQL_CREATE_ID_TABLE =
                  "CREATE TABLE " + "LogIn" + " ("
                  +
                          " ID " + " TEXT PRIMARY KEY NOT NULL , "+
                           " ROLE " + " TEXT NOT NULL , "+
                          " PASSWORD " + " TEXT NOT NULL ); ";

          final String SQL_CREATE_DETAILS_TABLE =
                  " CREATE TABLE " + " DETAILS " + " ( "
                  +
                          " ID " +    " TEXT PRIMARY KEY NOT NULL , "+
                          " NAME  " + " TEXT NOT NULL, "+
                          " EMAIL " + " TEXT NOT NULL, "+
                          " DOB " +   " TEXT NOT NULL, "+
                          " AGE " +   " INTEGER NOT NULL, "+
                         " GENDER " +" TEXT NOT NULL "+
                          ");";

          final String SQL_CREATE_MARKS_TABLE =
                " CREATE TABLE " + Provider.MARKS_DETAILS.TABLE_NAME + " ( "
                        +Provider.MARKS_DETAILS.id1 +    " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        Provider.MARKS_DETAILS.id +    " TEXT NOT NULL , "+
                        Provider.MARKS_DETAILS.SEM + " INTEGER NOT NULL, "+
                        Provider.MARKS_DETAILS.SUB_CODE + " TEXT NOT NULL, "+
                        Provider.MARKS_DETAILS.MARKS +   " INTEGER NOT NULL ,"+
                        "CONSTRAINT uni UNIQUE ( " +  Provider.MARKS_DETAILS.id +    " , "+
                        Provider.MARKS_DETAILS.SEM + " , "+
                        Provider.MARKS_DETAILS.SUB_CODE + "  ) " +
                        " );";


        Log.v("QUERY :",SQL_CREATE_ID_TABLE);

        db.execSQL(SQL_CREATE_ID_TABLE);
        db.execSQL( SQL_CREATE_DETAILS_TABLE);
        db.execSQL(SQL_CREATE_MARKS_TABLE);


        firstInsert(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+  " LogIn " );
        db.execSQL("DROP TABLE IF EXISTS "+  " DETAILS " );
        onCreate(db);
    }


    public void firstInsert(SQLiteDatabase db)
    {
        //ADMIN
        db.execSQL(" INSERT INTO LogIn (ID, ROLE , PASSWORD ) " +
                " VALUES ( 'ADMIN','admin','abcdef' ); ");
        db.execSQL(" INSERT INTO DETAILS (ID, NAME, EMAIL, DOB, AGE, GENDER) " +
                "VALUES ('ADMIN',' BOSS ','abc@gamil.com','29.05.1996','20','M'); ");

        //DEO
        db.execSQL(" INSERT INTO LogIn (ID, ROLE , PASSWORD ) " +
                " VALUES ( 'DEO1','deo','abcdef' ); ");
        db.execSQL(" INSERT INTO DETAILS (ID, NAME, EMAIL, DOB, AGE, GENDER) " +
                "VALUES ('DEO1',' DEO ','abc@gamil.com','09.05.2016','23','M'); ");


        //Faculty
        db.execSQL(" INSERT INTO LogIn (ID, ROLE ,PASSWORD ) " +
                " VALUES ( 'faculty','faculty','abcdef' ); ");
        db.execSQL(" INSERT INTO DETAILS (ID, NAME, EMAIL, DOB, AGE, GENDER) " +
                "VALUES ('faculty',' abcd ','abc@gamil.com','09.05.1993','23','F'); ");

        //STUDENT
        db.execSQL(" INSERT INTO LogIn (ID, ROLE ,PASSWORD ) " +
                " VALUES ( '2K14/SE/070','student','inspiron' ); ");
        db.execSQL(" INSERT INTO DETAILS (ID, NAME, EMAIL, DOB, AGE, GENDER) " +
                "VALUES ('2K14/SE/070','Rishabh ','abc@gamil.com','30.10.1996','20','M'); ");

        db.execSQL(" INSERT INTO MARKS_DETAILS ( ID, SEM , SUB_CODE, MARKS ) " +
                "VALUES ('2K14/SE/070','5','SE-201','90' ); ");

        db.execSQL(" INSERT INTO MARKS_DETAILS ( ID, SEM , SUB_CODE, MARKS ) " +
                "VALUES ('2K14/SE/070','3','SE-202','91' ); ");

        db.execSQL(" INSERT INTO MARKS_DETAILS ( ID, SEM , SUB_CODE, MARKS ) " +
                "VALUES ('2K14/SE/070','1','SE-204','91' ); ");
    }
}
