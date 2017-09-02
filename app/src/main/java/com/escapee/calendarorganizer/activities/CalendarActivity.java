package com.escapee.calendarorganizer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.escapee.calendarorganizer.layouts.CalendarView;

import com.escapee.calendarorganizer.R;
import com.escapee.calendarorganizer.constants.Intent_Constants;
import com.escapee.calendarorganizer.helpers.DatabaseHelper;
import com.escapee.calendarorganizer.models.UserCalendar;

public class CalendarActivity extends AppCompatActivity {

    CalendarView calendarView;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Intent intent = getIntent();
        String calId = intent.getStringExtra(Intent_Constants.INTENT_CALENDAR_ID);
        int calendarId = Integer.parseInt(calId);

        db = new DatabaseHelper(this);
        UserCalendar userCalendar = db.getCalendarById(calendarId);
        calendarView = (CalendarView) findViewById(R.id.calendar_view);
    }
}
