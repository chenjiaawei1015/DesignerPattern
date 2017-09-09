package com.example.test3;


import com.example.test1.ConcreateProductB;
import com.example.test1.Factory;
import com.example.test1.Product;

public class ConcreateFactoryB extends Factory {

    @Override
    public Product createProduct() {
        return new ConcreateProductB();
    }
}
