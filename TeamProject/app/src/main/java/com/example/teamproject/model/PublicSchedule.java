package com.example.teamproject.model;

import android.widget.CalendarView;

public class PublicSchedule {

    private String title;
    private String contents;
    private int year;
    private int month;
    private int day;

    public PublicSchedule(CalendarView calendarView, int i, int i1, int i2) {
    }

    public PublicSchedule(String title, String contents, int year, int month, int day) {
        this.title = title;
        this.contents = contents;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "PublicSchedule{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
