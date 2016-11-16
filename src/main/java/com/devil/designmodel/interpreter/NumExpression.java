package com.devil.designmodel.interpreter;

/**
 * 数字解释器，终结符表达式
 */
public class NumExpression extends ArithmeticExpression {
    private int num;

    public NumExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return num;
    }
}
