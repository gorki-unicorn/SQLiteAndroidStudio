package com.example.sqlitedemoapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class Dbmanager extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Employee.db";
    public static final String TABLE_NAME = "employee_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "DEPT_NAME";
    public static final String COL_4 = "PIN";

   // public static final String KEY_ID = "id"; // eash user has unique id
   // public static final String KEY_PIN = "pin";
   // public static final String KEY_NAME = "name";
   // public static final String KEY_DEPT = "dept";


    //private static  final int version = 1;
    public Dbmanager(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        // String sql="create table employee (id integer primary key autoincrement,pin text,name text, dept text)";
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DEPT_NAME TEXT,PIN INTEGER)");
        // db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String DEPT_NAME,String PIN)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,DEPT_NAME);
        contentValues.put(COL_4,PIN);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


}

