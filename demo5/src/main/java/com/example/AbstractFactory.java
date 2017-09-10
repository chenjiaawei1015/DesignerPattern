package com.example;


public abstract class AbstractFactory {

    // 创建产品A
    public abstract AbstractProductA createProductA();

    // 创建产品B
    public abstract AbstractProductB createProductB();
}
