package com.example.test1;

public class Client {

    public static void main(String[] args) {
        Factory factory = new ConcreateFactory();
        Product product = factory.createProduct();
        product.showProductName();
    }
}
