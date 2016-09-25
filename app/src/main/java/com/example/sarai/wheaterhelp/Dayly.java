package com.example.sarai.wheaterhelp;

import java.util.List;

/**
 * Created by sarai on 28/08/16.
 */
public class Dayly {
    private String summary;
    private String icon;
    private List<DaylyData> daylyDataList;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<DaylyData> getDaylyDataList() {
        return daylyDataList;
    }

    public void setDaylyDataList(List<DaylyData> daylyDataList) {
        this.daylyDataList = daylyDataList;
    }
}
