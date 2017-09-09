package com.example.test2;


public class ConcreateFactory extends Factory {

    @Override
    public <T extends Product> T createProduct(Class<T> clazz) {
        Product p = null;
        try {
            p = (Product) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) p;
    }
}
