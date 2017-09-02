package com.escapee.calendarorganizer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.escapee.calendarorganizer.R;
import com.escapee.calendarorganizer.models.UserCalendar;

import java.util.ArrayList;

/**
 * Created by steven.puckett on 8/27/2017.
 */

public class CalendarListAdapter extends BaseAdapter {

    LayoutInflater mInflator;
    ArrayList<UserCalendar> calendars;

    public CalendarListAdapter(Context context, ArrayList<UserCalendar> calendars){
        this.calendars = calendars;
        mInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return calendars.size();
    }

    @Override
    public Object getItem(int i) {
        return calendars.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = mInflator.inflate(R.layout.calendar_listview_detail, null);

        TextView calNameTextView = (TextView) v.findViewById(R.id.calNameTextView);
        TextView calIdTextView = (TextView) v.findViewById(R.id.calIdTextView);

        UserCalendar calName = calendars.get(i);

        calNameTextView.setText(calName.getCalendarName());
        calIdTextView.setText(Integer.toString(calName.getCalendarId()));

        return v;
    }
}
