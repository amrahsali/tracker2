package com.example.tracker;



public class Mapitem {
    String Longitude;
    String Latitude;
    String Name;
    String Uri;

    public Mapitem(String longitude, String latitude, String name, String uri) {
        this.Longitude = longitude;
        this.Latitude = latitude;
        this.Name = name;
        this.Uri = uri;
    }

    Mapitem(){}

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUri() {
        return Uri;
    }

    public void setUri(String uri) {
        Uri = uri;
    }
}

