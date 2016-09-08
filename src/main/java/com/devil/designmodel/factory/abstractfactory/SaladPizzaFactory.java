package com.devil.designmodel.factory.abstractfactory;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.SaladChinesePizza;
import com.devil.designmodel.factory.model.SaladUSPizza;
import com.devil.designmodel.factory.model.USPizza;

public class SaladPizzaFactory extends PizzaFactory {

    @Override
    public ChinesePizza createChinesePizza() {
        System.out.println("开始制作中国pizza");
        SaladChinesePizza pizza = new SaladChinesePizza();
        pizza.addFlour();
        pizza.addWater();
        pizza.addSeasoning();
        return pizza;
    }

    @Override
    public USPizza createUSPizza() {
        System.out.println("开始制作美国pizza");
        SaladUSPizza pizza = new SaladUSPizza();
        pizza.addFlour();
        pizza.addWater();
        pizza.addSeasoning();
        return pizza;
    }

}
