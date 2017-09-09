package com.example;


public class Person4 {

    // 静态内部类

    private Person4() {
    }

    public static Person4 getInstance() {
        return PersonInstance.sInstance;
    }

    private static class PersonInstance {
        static Person4 sInstance = new Person4();
    }

}
