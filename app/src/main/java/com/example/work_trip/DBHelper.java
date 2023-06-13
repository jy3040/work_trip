package com.example.work_trip;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE if not exists members ("
                + "member_num integer primary key autoincrement,"
                + "id text,"
                + "password text,"
                + "name text);";


        db.execSQL(sql);
        Log.d("DB", "table이 생성되었습니다.");
        Log.d("DB", db.toString());


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE if exists members";
        Log.d("DB", "table이 삭제되었습니다.");

        db.execSQL(sql);
        onCreate(db);
    }



}