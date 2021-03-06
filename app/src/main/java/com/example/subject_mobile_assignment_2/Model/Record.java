package com.example.subject_mobile_assignement_2.Model;

import java.io.Serializable;

public class Record implements Serializable {
    private String name;
    private int distance;
    private int coins;
    private double latitude;
    private double longitude;


    public Record(int distance, int coins, double latitude, double longitude, String name) {
        this.distance = distance;
        this.coins = coins;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public int getCoins() {
        return coins;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }
}
