package com.example.otonomarac;

public class Shop {
    public int getId() {
        return id;
    }
    private Shop shop;

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getPrice() {
        return price;
    }
    public Shop getShop() {
        return shop;
    }

    private int id;
    private String name;
    private double latitude;
    private double longitude;
    private double price;

    public Shop(int id, String name, double latitude, double longitude, double price){
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.price = price;
    }
}
