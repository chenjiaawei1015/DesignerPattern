package com.example;


public class Person3 {

    // DCL 模式

    private static Person3 sPerson;

    private Person3() {
    }

    public static Person3 getInstance() {
        if (sPerson == null) {
            synchronized (Person3.class) {
                if (sPerson == null) {
                    sPerson = new Person3();
                }
            }
        }
        return sPerson;
    }
}
