package com.example;


public class BicyclerStrategy implements IPriceStrategy {

    @Override
    public int calculatePrice(int millis) {
        return millis;
    }
}
