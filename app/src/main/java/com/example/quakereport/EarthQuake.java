package com.example.quakereport;

import java.util.Date;

public class EarthQuake {
    private String location;
    private double magnitude;
    private long date;
    private String url;

    public EarthQuake(String location, double magnitude, long date, String url) {
        this.location = location;
        this.magnitude = magnitude;
        this.date = date;
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
