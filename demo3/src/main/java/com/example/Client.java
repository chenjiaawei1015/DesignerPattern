package com.example;


import java.util.ArrayList;
import java.util.Collections;

public class Client {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Jack";

        Person friend1 = new Person();
        friend1.name = "f1";
        Person friend2 = new Person();
        friend2.name = "f2";
        ArrayList<Person> friendList = new ArrayList<>();
        Collections.addAll(friendList, friend1, friend2);
        p1.friendList = friendList;

        try {
            Person clonePerson = p1.clone();

            p1.name = "Rose";

            Person friend3 = new Person();
            friend3.name = "f3";
            Person friend4 = new Person();
            friend4.name = "f4";
            ArrayList<Person> friendList2 = new ArrayList<>();
            Collections.addAll(friendList2, friend1, friend2);
            p1.friendList = friendList2;

            int i = 1;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
