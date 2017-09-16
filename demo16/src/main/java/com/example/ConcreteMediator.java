package com.example;

/**
 * 具体中介者
 */
public class ConcreteMediator extends Mediator {

    @Override
    public void method() {
        mColleagueA.action();
        mColleagueB.action();
    }
}
