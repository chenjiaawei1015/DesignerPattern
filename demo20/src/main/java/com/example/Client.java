package com.example;

public class Client {

    public static void main(String[] args) {
        Person person = new Boy();
        PersonCloth cloth = new CheapCloth(person);
        cloth.dressed();
    }
}
