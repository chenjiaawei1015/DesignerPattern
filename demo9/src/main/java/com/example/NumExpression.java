package com.example;

/**
 * 数字解释器
 */
public class NumExpression extends ArithmeticExpression {

    private int mNum;

    public NumExpression(int num) {
        this.mNum = num;
    }

    @Override
    public int interpreter() {
        return this.mNum;
    }
}
