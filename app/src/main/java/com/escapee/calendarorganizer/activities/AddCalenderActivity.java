package com.escapee.calendarorganizer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.escapee.calendarorganizer.helpers.DatabaseHelper;
import com.escapee.calendarorganizer.R;

public class AddCalenderActivity extends AppCompatActivity {

    EditText calNameTextView;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_calender);

        db = new DatabaseHelper(this);
        calNameTextView = (EditText) findViewById(R.id.calNameEditText);
    }

    public void saveCalendar(View view) {
        String calName = calNameTextView.getText().toString();

        if(!calName.equals("")){
            boolean isInserted = db.insertCalendar(calName);
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
