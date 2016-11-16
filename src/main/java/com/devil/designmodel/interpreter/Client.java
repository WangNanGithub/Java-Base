package com.devil.designmodel.interpreter;

public class Client {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.calculate("1 + 4"));
        System.out.println(c.calculate("1 - 4"));

    }
}
