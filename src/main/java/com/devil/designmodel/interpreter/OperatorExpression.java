package com.devil.designmodel.interpreter;

/**
 * 运算符抽象解释器，因为有多种运算符，方便以后维护
 */
public abstract class OperatorExpression extends ArithmeticExpression {
    protected ArithmeticExpression exp1, exp2;

    public OperatorExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
}
