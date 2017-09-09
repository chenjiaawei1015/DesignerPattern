package com.example.test2;

public class Client {

    public static void main(String[] args) {
        Factory factory = new ConcreateFactory();
        Product product = factory.createProduct(ConcreateProductB.class);
        product.showProductName();
    }
}
