package com.example.sarai.wheaterhelp;

import java.util.List;

/**
 * Created by sarai on 28/08/16.
 */
public class Hourly {
    private String summary;
    private String icon;
    private List<HourlyData> hourlyDataList;

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

    public List<HourlyData> getHourlyDataList() {
        return hourlyDataList;
    }

    public void setHourlyDataList(List<HourlyData> hourlyDataList) {
        this.hourlyDataList = hourlyDataList;
    }
}
