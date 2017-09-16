package com.example;

/**
 * 抽象同事
 */
public abstract class Colleague {

    // 中介者对象
    protected Mediator mMediator;

    public Colleague(Mediator mediator) {
        mMediator = mediator;
    }

    // 同事具体的行为
    public abstract void action();
}
