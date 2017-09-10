package com.example;

public class Client {

    public static void main(String[] args) {

        AbstractFactory factory = new ConcreateFactory1();
        AbstractProductA productA = factory.createProductA();
        AbstractProductB productB = factory.createProductB();
        productA.method();
        productB.method();
    }
}
