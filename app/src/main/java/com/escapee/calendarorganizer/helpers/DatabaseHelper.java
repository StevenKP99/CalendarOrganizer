package com.escapee.calendarorganizer.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.escapee.calendarorganizer.models.UserCalendar;

import java.util.ArrayList;

/**
 * Created by steven.puckett on 8/30/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "CalendarOrganizer.db";
    public static final String CALENDAR_TABLE = "calendar_table";
    public static final String CALENDAR_ID = "cal_id";
    public static final String CALENDAR_NAME = "name";
    public static final String CALENDAR_FAVORITE = "favorite";
    public static final String CALENDAR_COLOR = "color";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + CALENDAR_TABLE + " ( "
                + CALENDAR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CALENDAR_NAME + " TEXT, "
                + CALENDAR_FAVORITE + " INTEGER, "
                + CALENDAR_COLOR +" TEXT )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CALENDAR_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean insertCalendar(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put(CALENDAR_NAME, name);
        long result = db.insert(CALENDAR_TABLE, null, contentValue);
        return (result == -1 ? false : true);
    }

    public UserCalendar getCalendarById(int calendarId){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CALENDAR_TABLE + " WHERE " +
                CALENDAR_ID + " = " + calendarId, null);
        UserCalendar userCalendar = null;
        if(cursor.getCount() == 0) {
            return null;
        } else {
            while(cursor.moveToNext()){
                userCalendar = new UserCalendar(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
            }
        }
        return userCalendar;
    }

    public ArrayList<UserCalendar> getAllCalendars(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CALENDAR_TABLE + " ORDER BY " +
                CALENDAR_FAVORITE, null);


        ArrayList<UserCalendar> userCalendars = new ArrayList<UserCalendar>();
        if(cursor.getCount() == 0) {
            return userCalendars;
        } else {
            while(cursor.moveToNext()){
                UserCalendar userCalendar = new UserCalendar(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
                userCalendars.add(userCalendar);
            }
        }
        return userCalendars;
    }
}
