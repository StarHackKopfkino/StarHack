package com.example.otonomarac;


import java.util.ArrayList;

public class Storage {
    private static Storage mInstance = null;

    Shop shop1 = new Shop(1, "TESLA", 48.7791242, 9.0371319, 0.25);
    Shop shop2 = new Shop(2, "MERCEDES-BENZ", 48.810335, 9.1461793, 0.50);
    Shop shop3 = new Shop(3, "CITROEN", 48.910639,9.2447093, 0.75);
    Shop shop4 = new Shop(4, "FORD", 48.815678,9.1457093, 0.75);
    Shop shop5 = new Shop(5, "RENAULT", 48.810999,9.1547093, 0.75);
    Shop shop6 = new Shop(6, "VOLKSWAGEN", 48.810345,9.1887093, 0.75);
    Shop shop7 = new Shop(7, "TOYOTA", 48.810666,9.1987093, 0.75);
    public Shop[] shops = { shop1 ,shop2,shop3,shop4,shop5,shop6,shop7};

    public ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    protected Storage(){}

    public static synchronized Storage getInstance() {
        if (null == mInstance) {
            mInstance = new Storage();
        }
        return mInstance;
    }

    // Iterate through shops to get shop with given id.
    // Returns null if no shop with id exists.
    public synchronized Shop getShopById(int id){
        for(Shop shop : this.shops){
            if(shop.getId() == id){
                return shop;
            }
        }
        return null;
    }

    public synchronized Reservation getReservationById(int id){
        for(Reservation reservation : this.reservations){
            if(reservation.getId() == id){
                return reservation;
            }
        }
        return null;
    }
}
