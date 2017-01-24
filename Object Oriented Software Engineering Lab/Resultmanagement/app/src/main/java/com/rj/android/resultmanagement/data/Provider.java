package com.rj.android.resultmanagement.data;

import android.net.Uri;

public class Provider {

    public static final class LOGIN {


        public static final String TABLE_NAME = "LogIn";
        public static final String Columns[] = {"ID" , "ROLE", "PASSWORD"};
        public static final String id = "ID";
        public static final String role = "ROLE";
        public static final String PASSWORD = "PASSWORD";
    }


    public static final class DETAILS {


        public static final String TABLE_NAME = " DETAILS ";

        public static final String id = "ID";
        public static final String NAME = "NAME";
        public static final String EMAIL = "EMAIL";
        public static final String DOB = "DOB";
        public static final String AGE = "AGE";
        public static final String GENDER = "GENDER";


        public static final String Columns[] = {id,NAME,EMAIL,DOB,AGE,GENDER};

    }

    public static final class MARKS_DETAILS {


        public static final String TABLE_NAME = "MARKS_DETAILS";
        public static final String id1 = "_id";
        public static final String id = "ID";
        public static final String SEM = "SEM";
        public static final String SUB_CODE = "SUB_CODE";
        public static final String MARKS = "MARKS";

        public static final String Columns[] = {id,SEM , SUB_CODE , MARKS};
    }



}
