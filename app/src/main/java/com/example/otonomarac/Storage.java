package com.example.otonomarac;


public class Storage {
    private static Storage mInstance = null;

    Shop shop1 = new Shop(1, "Tesla", 50, 50, 7);
    public Shop[] shops = { shop1 };

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
}