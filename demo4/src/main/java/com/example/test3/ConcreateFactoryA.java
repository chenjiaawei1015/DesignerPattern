package com.example.test3;


import com.example.test1.ConcreateProductA;
import com.example.test1.Factory;
import com.example.test1.Product;

public class ConcreateFactoryA extends Factory {

    @Override
    public Product createProduct() {
        return new ConcreateProductA();
    }
}
