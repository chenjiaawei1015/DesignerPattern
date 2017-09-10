package com.example;


public class PowerOnState implements TvState {

    @Override
    public void changeChannel() {
        System.out.println("change channel");
    }
}
