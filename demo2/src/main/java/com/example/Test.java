package com.example;


public class Test {

    public static void main(String[] args) {
        Builder builder = new MacBookBuilder();
        Director director = new Director(builder);

        Computer computer = director.construct("英特尔主机", "三星显示器");
        if (computer == null) {

        }
    }
}
