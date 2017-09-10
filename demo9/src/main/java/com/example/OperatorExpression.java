package com.example;

/**
 * 运算符号抽象解释器
 */
public abstract class OperatorExpression extends ArithmeticExpression {

    // 存储运算符号两边的数字解释器
    protected ArithmeticExpression mExp1, mExp2;

    public OperatorExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        mExp1 = exp1;
        mExp2 = exp2;
    }
}
