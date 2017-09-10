package com.example;

/**
 * 加法运算抽象解释器
 */
public class AdditionExpression extends OperatorExpression {

    public AdditionExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpreter() {
        return mExp1.interpreter() + mExp2.interpreter();
    }
}
