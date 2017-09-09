package com.example;

import java.util.ArrayList;

public class Person implements Cloneable {

    public String name;
    public ArrayList<Person> friendList;

    @Override
    public Person clone() throws CloneNotSupportedException {
        return shallowCopy();
    }

    /**
     * 浅拷贝
     */
    private Person shallowCopy() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    /**
     * 深拷贝
     */
    private Person deepCopy() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.friendList = (ArrayList<Person>) friendList.clone();
        return person;
    }
}
