package com.zxc.model;

import java.util.Date;

public class WorkDay {
    private Integer id;

    private Date startDate;

    private Date endDate;

    private Integer isWorkDay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getIsWorkDay() {
        return isWorkDay;
    }

    public void setIsWorkDay(Integer isWorkDay) {
        this.isWorkDay = isWorkDay;
    }
}