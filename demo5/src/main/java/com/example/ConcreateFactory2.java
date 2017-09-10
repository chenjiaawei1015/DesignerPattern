package com.example;


public class ConcreateFactory2 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreateProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreateProductB2();
    }
}
