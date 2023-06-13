package com.example.work_trip;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CommunityDBHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String DATABASE_NAME = "worktrip.db";
    public static final int DATABASE_VERSION = 2;

    public static final String TABLE_NAME = "community";
    public static final String COLUMN_ID = "commu_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_DURATION = "duration";
    public static final String COLUMN_PEOPLE = "people";
    public static final String COLUMN_GOOD = "good";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_THEMA = "thema";
    public static final String COLUMN_MONEY = "money";
    public static final String COLUMN_CONTENT = "content";

    public CommunityDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TABLE_NAME+
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_COMPANY + " TEXT, " +
                COLUMN_MONEY + " TEXT, " +
                COLUMN_DURATION + " TEXT, " +
                COLUMN_PEOPLE + " TEXT, " +
                COLUMN_GOOD + " TEXT, " +
                COLUMN_IMG + " BLOP, " +
                COLUMN_CONTENT + " TEXT, " +
                COLUMN_THEMA + " TEXT);";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public Cursor readAllData(){
        String sql = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(sql, null);
        }
        return cursor;
    }


    public Cursor readDatabytag(String tag){
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE thema = " + tag;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(sql, null);
        }
        return cursor;
    }

    public int addData(String title, String date, String company, String money,
                        String duration, String people, String good, byte[] img, String thema, String content){
       SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_COMPANY, company);
        cv.put(COLUMN_MONEY, money);
        cv.put(COLUMN_DURATION, duration);
        cv.put(COLUMN_PEOPLE, people);
        cv.put(COLUMN_GOOD, good);
        cv.put(COLUMN_THEMA, thema);
        cv.put(COLUMN_CONTENT, content);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return 0;
        }
        else{
            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();
            return 1;

        }
    }
}
