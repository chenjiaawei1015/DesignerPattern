package com.example;

import java.util.Stack;

/**
 * 处理和解释相关的一些业务
 */
public class Calculator {

    private Stack<ArithmeticExpression> mExpStack = new Stack<>();

    public Calculator(String expression) {
        // 两个临时变量,存储运算符左右两边的解释器
        ArithmeticExpression exp1, exp2;

        // 根据空格分割表达式字符串
        String[] elements = expression.split(" ");

        for (int i = 0; i < elements.length; i++) {
            // 判断运算符号
            switch (elements[i].charAt(0)) {
                case '+':
                    // 加号运算符
                    // 将栈中的解释器弹出作为运算符左边的解释器
                    exp1 = mExpStack.pop();
                    // 将运算符号数组下标下一个元素构造为一个数字解释器
                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
                    // 通过上面两个数字解释器构造加号运算解释器
                    mExpStack.push(new AdditionExpression(exp1, exp2));
                    break;

                case '-':
                    // 减号运算符
                    // 将栈中的解释器弹出作为运算符左边的解释器
                    exp1 = mExpStack.pop();
                    // 将运算符号数组下标下一个元素构造为一个数字解释器
                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
                    // 通过上面两个数字解释器构造减号运算解释器
                    mExpStack.push(new SubtractionExpression(exp1, exp2));
                    break;

                default:
                    // 为数字
                    // 直接构造数字解释器并压入堆栈
                    mExpStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }
    }

    // 计算最终结果
    public int calculate() {
        return mExpStack.pop().interpreter();
    }
}
