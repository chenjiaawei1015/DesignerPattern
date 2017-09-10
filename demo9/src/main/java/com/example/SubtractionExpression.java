package com.example;

/**
 * 减法运算抽象解释器
 */
public class SubtractionExpression extends OperatorExpression {

    public SubtractionExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpreter() {
        return mExp1.interpreter() - mExp2.interpreter();
    }
}
