package com.example.otonomarac;


public class Storage {
    private static Storage mInstance = null;

    Shop shop1 = new Shop(1, "Tesla", 50, 50, 7);
    public Shop[] shops = { shop1 };

    Reservation reservation1 = new Reservation(1, 17, 06, 2021, 12,
            30,30,1);
    public Reservation[] reservations = { reservation1 };

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
