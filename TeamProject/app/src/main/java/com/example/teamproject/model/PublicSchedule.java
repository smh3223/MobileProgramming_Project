package com.example.teamproject.model;

import java.util.Date;

public class PublicSchedule {

    private Date ThatDate;
    private String title;
    private String contents;

    public PublicSchedule() {
    }

    public PublicSchedule(Date startDate, Date lastDate, String title, String contents) {
        this.ThatDate = startDate;
        this.title = title;
        this.contents = contents;
    }

    public Date getStartDate() {
        return ThatDate;
    }


    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public void setStartDate(Date startDate) {
        this.ThatDate = startDate;
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
                "startDate=" + ThatDate +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
