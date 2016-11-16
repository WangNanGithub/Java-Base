package com.devil.designmodel.interpreter;

/**
 * 减法解释器
 */
public class SubtractExpression extends OperatorExpression {

    public SubtractExpression(ArithmeticExpression exp1, ArithmeticExpression exp2) {
        super(exp1, exp2);
    }

    @Override
    public int interpret() {
        return exp1.interpret() - exp2.interpret();
    }
}
