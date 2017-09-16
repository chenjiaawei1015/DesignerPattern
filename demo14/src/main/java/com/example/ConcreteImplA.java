package com.example;

public class ConcreteImplA extends AbsTemplate {

    @Override
    void stepOne() {
        System.out.println("A one");
    }

    @Override
    void stepTwo() {
        System.out.println("A two");
    }
}
