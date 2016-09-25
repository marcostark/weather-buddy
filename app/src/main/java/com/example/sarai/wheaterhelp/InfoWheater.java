package com.example.sarai.wheaterhelp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by sarai on 28/08/16.
 */
public class InfoWheater {
    private double latitude;
    private double longitude;
    private String timezone;
    private int offset;
    private CurrentWeather currentWeather;
    private Minutely minutelyList;
    private Hourly hourlyList;
    private Dayly daylyList;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public Minutely getMinutelyList() {
        return minutelyList;
    }

    public void setMinutelyList(Minutely minutelyList) {
        this.minutelyList = minutelyList;
    }

    public Hourly getHourlyList() {
        return hourlyList;
    }

    public void setHourlyList(Hourly hourlyList) {
        this.hourlyList = hourlyList;
    }

    public Dayly getDaylyList() {
        return daylyList;
    }

    public void setDaylyList(Dayly daylyList) {
        this.daylyList = daylyList;
    }

    public String getFormatterData(Long time){
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        String timeString = formatter.format(new Date(time * 1000));
        return timeString;
    }
}
