package com.example;

public class Client {

    public static void main(String[] args) {
        TvController controller = new TvController();
        controller.changeChannel();

        controller.powerOn();
        controller.changeChannel();

        controller.powerOff();
        controller.changeChannel();
    }
}
