package com.example.haitm.sqlitedemo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "my_db";
    public static final String TABLE_NAME = "sinh_vien";
    public static final int DATABASE_VERSION = 2;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "full_name VARCHAR(100)," +
                "student_id VARCHAR (8), " +
                "gender INTEGER DEFAULT 1," +
                "year INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
