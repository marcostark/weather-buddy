package com.example.sarai.wheaterhelp;

/**
 * Created by sarai on 28/08/16.
 */
public class WheaterData {
    private long time;
    private double precipIntensity;
    private double precipProbability;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }
}
