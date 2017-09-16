package com.example;


public class Client {

    public static void main(String[] args) {
        AbsTemplate template = new ConcreteImplA();
        template.execute();
    }
}
