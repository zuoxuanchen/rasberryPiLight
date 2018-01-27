package com.zxc.model;

public class Hints {
    private Integer id;

    private Integer year;

    private Integer month;

    private Integer day;

    private Integer oldYear;

    private Integer oldMonth;

    private Integer oldDay;

    private Integer scheduleDay;

    private String birthName;

    private String hints;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getOldYear() {
        return oldYear;
    }

    public void setOldYear(Integer oldYear) {
        this.oldYear = oldYear;
    }

    public Integer getOldMonth() {
        return oldMonth;
    }

    public void setOldMonth(Integer oldMonth) {
        this.oldMonth = oldMonth;
    }

    public Integer getOldDay() {
        return oldDay;
    }

    public void setOldDay(Integer oldDay) {
        this.oldDay = oldDay;
    }

    public Integer getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(Integer scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public String getBirthName() {
        return birthName;
    }

    public void setBirthName(String birthName) {
        this.birthName = birthName == null ? null : birthName.trim();
    }

    public String getHints() {
        return hints;
    }

    public void setHints(String hints) {
        this.hints = hints == null ? null : hints.trim();
    }
}