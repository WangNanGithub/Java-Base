package com.devil.designmodel.factory.staticfactory;

public class PizzaFactory {
    private static Pizza pizza;

    public static Pizza createPizza(String type) {
        switch (type) {
        case "US":
            System.out.println("工厂开始生产USPizza");
            pizza = new USPizza();
            pizza.addFlour();
            pizza.addWater();
            break;
        case "Chinese":
            System.out.println("工厂开始生产ChinesePizza");
            pizza = new ChinesePizza();
            pizza.addFlour();
            pizza.addWater();
            break;
        default:
            System.out.println("此工厂无法生产此类Pizza");
            break;
        }
        return pizza;
    }
}
