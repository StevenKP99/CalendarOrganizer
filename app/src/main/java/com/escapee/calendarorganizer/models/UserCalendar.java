package com.escapee.calendarorganizer.models;

/**
 * Created by steven.puckett on 8/30/2017.
 */

public class UserCalendar {
    private int calendarId;
    private String calendarName;
    private Integer favorite;
    private String color;

    public UserCalendar(int calendarId, String calendarName, Integer favorite, String color){
        this.calendarId = calendarId;
        this.calendarName = calendarName;
        this.favorite = favorite;
        this.color = color;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
