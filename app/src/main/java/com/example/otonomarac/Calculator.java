package com.example.otonomarac;

public  class Calculator {

    public static double calculation(int minute, double price) {

        int timeOfCharge = minute;
        double totalPrice = timeOfCharge * price;

        return totalPrice;
    }
}
