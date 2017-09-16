package com.example;


public abstract class AbsTemplate {

    abstract void stepOne();

    abstract void stepTwo();

    void execute() {
        stepOne();
        stepTwo();
    }
}
