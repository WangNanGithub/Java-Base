package com.devil.designmodel.interpreter;

import java.util.Stack;

/**
 * 计算器，环境类
 */
public class Calculator {
    // 使用stack，后进先出，记录所有操作
    private Stack<ArithmeticExpression> stack = new Stack<ArithmeticExpression>();

    // 这里规定好，数字和符号之间用空格分隔
    public int calculate(String exp) {
        String[] eles = exp.split(" ");
        for (int i = 0; i < eles.length; i++) {
            NumExpression front = null; // 保留运算符前面的值
            NumExpression next = null;// 保留运算符后面的值
            switch (eles[i]) {
            case "+":
                front = (NumExpression) stack.peek();
                next = new NumExpression(Integer.valueOf(eles[++i]));
                stack.push(next);
                stack.push(new AdditionExpression(front, next));
                break;
            case "-":
                front = (NumExpression) stack.peek();
                next = new NumExpression(Integer.valueOf(eles[++i]));
                stack.push(next);
                stack.push(new SubtractExpression(front, next));
                break;
            default:
                // 其他为数字
                stack.push(new NumExpression(Integer.valueOf(eles[i])));
                break;
            }
        }
        return stack.peek().interpret();
    }
}
