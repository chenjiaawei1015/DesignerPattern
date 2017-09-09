package com.example.test1;


public class ConcreateFactory extends Factory {

    @Override
    public Product createProduct() {
        // 生产具体的产品
        return new ConcreateProductA();
        // return new ConcreateProductB();
    }
}
