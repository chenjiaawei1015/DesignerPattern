package com.example;

public class Client {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);

        mediator.setColleagueA((ConcreteColleagueA) colleagueA);
        mediator.setColleagueB((ConcreteColleagueB) colleagueB);

        mediator.method();
    }

}
