package com.example;


public class Person2 {

    // 懒汉模式

    private static Person2 sPerson;

    private Person2() {
    }

    public static synchronized Person2 getInstance() {
        if (sPerson == null) {
            sPerson = new Person2();
        }
        return sPerson;
    }
}
