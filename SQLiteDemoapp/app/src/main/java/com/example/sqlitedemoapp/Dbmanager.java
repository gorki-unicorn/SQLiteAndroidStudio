package com.example.sqlitedemoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Dbmanager extends SQLiteOpenHelper {
    public static  final String dbname="uddipandb";
    public Dbmanager(Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry= "create table tbl_empinfo(id integer  primary key autoincrement,pin integer,name text, dept text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS tbl_empinfo");
     onCreate(db);

    }

    public String addRecord(String p1,String p2, String p3)
    {

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("pin",p1);
        cv.put("name",p2);
        cv.put("dept",p3);

        long res=db.insert("tbl_empinfo",null,cv);

        if(res==-1)
            return  "Failed";
        else
            return "Sucessfully Inserted";

    }
}
