package com.example;

/**
 * CTO 关注代码数量和产品数量
 */
public class CTOVisitor implements Visitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println(engineer.name + " codes = " + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(manager.name + " products = " + manager.getProducts());
    }
}
