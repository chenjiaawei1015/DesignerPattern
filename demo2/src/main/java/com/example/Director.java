package com.example;


public class Director {

    // 负责构造Computer

    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public Computer construct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOs();
        return mBuilder.create();
    }
}
