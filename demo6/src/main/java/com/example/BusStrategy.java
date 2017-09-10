package com.example;


public class BusStrategy implements IPriceStrategy {

    @Override
    public int calculatePrice(int millis) {
        return 2 * millis;
    }
}
