package com.devil.designmodel.factory.staticfactory;

public class TestMian {
    public static void main(String[] args) {
        ChinesePizza pizza = (ChinesePizza) PizzaFactory.createPizza("Chinese");
        USPizza usPizza = (USPizza) PizzaFactory.createPizza("US");
        USPizza ussPizza = (USPizza) PizzaFactory.createPizza("");
    }
}
