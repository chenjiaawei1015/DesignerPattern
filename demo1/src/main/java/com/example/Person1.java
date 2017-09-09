package com.example;


public class Person1 {

    // 恶汉模式

    private static Person1 sPerson1 = new Person1();

    private Person1() {
    }

    public static Person1 getInstance() {
        return sPerson1;
    }
}
