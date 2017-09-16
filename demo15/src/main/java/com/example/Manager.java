package com.example;


public class Manager extends Staff {

    private int products;

    public Manager(String name) {
        super(name);
        products = RandomUtils.getInt(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getProducts() {
        return products;
    }
}
