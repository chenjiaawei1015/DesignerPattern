package com.example;

public class Client {

    public static void main(String[] args) {
        Travel travel = new Travel(new BusStrategy());
        int price = travel.calculatePrice(10);
        System.out.println(price);

        travel = new Travel(new BicyclerStrategy());
        price = travel.calculatePrice(10);
        System.out.println(price);
    }
}
