package com.example;


public class ConcreateFactory1 extends AbstractFactory {

    @Override
    public AbstractProductA createProductA() {
        return new ConcreateProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ConcreateProductB1();
    }
}
