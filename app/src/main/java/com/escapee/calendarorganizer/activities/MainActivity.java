package com.escapee.calendarorganizer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.escapee.calendarorganizer.R;
import com.escapee.calendarorganizer.adapters.CalendarListAdapter;
import com.escapee.calendarorganizer.constants.Intent_Constants;
import com.escapee.calendarorganizer.helpers.DatabaseHelper;
import com.escapee.calendarorganizer.models.UserCalendar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView calList;
    ArrayList<UserCalendar> userCalendars;
    CalendarListAdapter calAdapter;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        intitalizeCalendarList();

    }

    private void intitalizeCalendarList() {
        calList = (ListView) findViewById(R.id.calListView);

        userCalendars = db.getAllCalendars();

        if(calAdapter == null) {
            calAdapter = new CalendarListAdapter(this, userCalendars);
        }
        calList.setAdapter(calAdapter);
        calList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String calId =  ((TextView)view.findViewById(R.id.calIdTextView)).getText().toString();
                if(calId != "") {
                    Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);
                    intent.putExtra(Intent_Constants.INTENT_CALENDAR_ID, calId);
                    startActivity(intent);
                }
            }
        });
    }

    //OnClickListener for ADD button
    public void addEditCalendar(View v){
        Intent intent = new Intent(this, AddCalenderActivity.class);
        startActivity(intent);
        //startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE);
    }

    public void goToCalendar(View v){
        Intent intent = new Intent(this, CalendarActivity.class);

    }
}
