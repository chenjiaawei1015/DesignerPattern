package com.example.test3;

import com.example.test1.Factory;
import com.example.test1.Product;

public class Client {

    public static void main(String[] args) {
        Factory factory = new ConcreateFactoryA();
        Product product = factory.createProduct();
        product.showProductName();

        factory = new ConcreateFactoryB();
        product = factory.createProduct();
        product.showProductName();
    }
}
