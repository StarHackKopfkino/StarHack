package com.example.otonomarac;

public  class Calculator {

    public static double calculateTotalPrice(int minute, double price) {

        int timeOfCharge = minute;
        double totalPrice = timeOfCharge * price;

        return totalPrice;
    }
}
