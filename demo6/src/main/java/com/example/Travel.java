package com.example;


public class Travel {

    private IPriceStrategy mPriceStrategy;

    public Travel(IPriceStrategy priceStrategy) {
        mPriceStrategy = priceStrategy;
    }

    public int calculatePrice(int millis) {
        return mPriceStrategy.calculatePrice(millis);
    }
}
