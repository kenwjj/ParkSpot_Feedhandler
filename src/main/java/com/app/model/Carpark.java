package com.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Kenwjj on 23/2/2017.
 */
public class Carpark {

    private int CarParkID;
    private String Area;
    private String Development;
    private double Latitude;
    private double Longitude;
    private int Lots;
    private Timestamp lastUpdated =  new Timestamp(new Date().getTime());

    public Carpark() {
    }

    @JsonCreator
    public Carpark(@JsonProperty("CarParkID")int carParkID, @JsonProperty("Area")String area,
                   @JsonProperty("Development")String development, @JsonProperty("Latitude")double latitude,
                   @JsonProperty("Longitude")double longitude, @JsonProperty("Lots")int lots) {
        CarParkID = carParkID;
        Area = area;
        Development = development;
        Latitude = latitude;
        Longitude = longitude;
        Lots = lots;
    }

    public int getCarParkID() {
        return CarParkID;
    }

    public void setCarParkID(int carParkID) {
        CarParkID = carParkID;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getDevelopment() {
        return Development;
    }

    public void setDevelopment(String development) {
        Development = development;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public int getLots() {
        return Lots;
    }

    public void setLots(int lots) {
        Lots = lots;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Carpark{" +
                "CarParkID=" + CarParkID +
                ", Area='" + Area + '\'' +
                ", Development='" + Development + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Lots=" + Lots +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
