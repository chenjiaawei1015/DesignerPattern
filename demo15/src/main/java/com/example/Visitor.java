package com.example;


public interface Visitor {

    void visit(Engineer engineer);

    void visit(Manager manager);
}
