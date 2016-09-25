package com.example.sarai.wheaterhelp;

import java.util.List;

/**
 * Created by sarai on 28/08/16.
 */
public class Minutely {
    private String summary;
    private String icon;
    private List<WheaterData> wheaterDataList;

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

    public List<WheaterData> getWheaterDataList() {
        return wheaterDataList;
    }

    public void setWheaterDataList(List<WheaterData> wheaterDataList) {
        this.wheaterDataList = wheaterDataList;
    }
}
