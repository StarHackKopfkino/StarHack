package com.example.otonomarac;

public class Reservation { //tarih başlama saati başlama dakikası location süre id

    public int getId() {
        return id;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    public int getHourOfBeginning() {
        return hourOfBeginning;
    }
    public int getmMnuteOfBeginning() {
        return minuteOfBeginning;
    }

    public int getChargeDuration() {
        return chargeDuration;
    }
    public Shop getShop() {
        return shop;
    }


    private int id;

    private int day;
    private int month;
    private int year;

    private int hourOfBeginning;
    private int minuteOfBeginning;

    private int chargeDuration;
    private Shop shop;

    public Reservation(int id, int day, int month, int year, int hourOfBeginning, int minuteOfBeginning, int chargeDuration, Shop shop) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hourOfBeginning = hourOfBeginning;
        this.minuteOfBeginning = minuteOfBeginning;
        this.chargeDuration = chargeDuration;
        this.shop = shop;
    }
}
