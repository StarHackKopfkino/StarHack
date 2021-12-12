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

    public int gethourOfBeginning() {
        return hourOfBeginning;
    }
    public int getminuteOfBeginning() {
        return minuteOfBeginning;
    }

    public int getchargeDuration() {
        return chargeDuration;
    }
    public int getShopId() {
        return shopId;
    }


    private int id;

    private int day;
    private int month;
    private int year;

    private int hourOfBeginning;
    private int minuteOfBeginning;

    private int chargeDuration;
    private int shopId;

    public Reservation(int id, int day, int month, int year, int hourOfBeginning, int minuteOfBeginning, int chargeDuration, int shopId) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hourOfBeginning = hourOfBeginning;
        this.minuteOfBeginning = minuteOfBeginning;
        this.chargeDuration = chargeDuration;
        this.shopId = shopId;
    }
}
