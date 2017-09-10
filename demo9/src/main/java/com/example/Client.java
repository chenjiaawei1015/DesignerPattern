package com.example;

public class Client {

    public static void main(String[] args) {
        Calculator calculator = new Calculator("10 + 15 - 5 - 10 + 20");
        int num = calculator.calculate();
        System.out.println(num);
    }
}
