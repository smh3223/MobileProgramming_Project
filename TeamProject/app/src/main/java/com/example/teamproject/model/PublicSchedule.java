package com.example.teamproject.model;

import java.util.Date;

public class Schedule {

    private Date startDate;
    private Date lastDate;
    private String title;
    private String contents;

    public Schedule() {
    }

    public Schedule(Date startDate, Date lastDate, String title, String contents) {
        this.startDate = startDate;
        this.lastDate = lastDate;
        this.title = title;
        this.contents = contents;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "startDate=" + startDate +
                ", lastDate=" + lastDate +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
