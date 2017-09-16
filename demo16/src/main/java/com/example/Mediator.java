package com.example;

/**
 * 抽象中介者
 */
public abstract class Mediator {

    protected Colleague mColleagueA;
    protected Colleague mColleagueB;

    public void setColleagueA(ConcreteColleagueA colleagueA) {
        mColleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB) {
        mColleagueB = colleagueB;
    }

    public abstract void method();
}
