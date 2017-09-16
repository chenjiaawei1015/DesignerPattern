package com.example;

public class Client {

    public static void main(String[] args) {
        Aggregate<String> list = new ConcreteAggregate<>();
        list.add("Android");
        list.add("Java");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String data = iterator.next();
            System.out.println(data);
        }
    }
}
