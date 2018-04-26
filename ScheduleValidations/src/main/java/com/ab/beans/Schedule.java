package com.ab.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private String frequency;
    private Date startDate;
    private String executeAt;
    private List<Integer> recurrence;
    private Integer executeOn;

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getExecuteAt() {
        return executeAt;
    }

    public void setExecuteAt(String executeAt) {
        this.executeAt = executeAt;
    }

    public List<Integer> getRecurrence() {
        if(recurrence == null) {
            recurrence = new ArrayList<>(0);
        }
        return recurrence;
    }

    public void setRecurrence(List<Integer> recurrence) {
        this.recurrence = recurrence;
    }

    public Integer getExecuteOn() {
        return executeOn;
    }

    public void setExecuteOn(Integer executeOn) {
        this.executeOn = executeOn;
    }
}
