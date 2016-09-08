package com.devil.designmodel.factory.abstractfactory;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.KetchupChinesePizza;
import com.devil.designmodel.factory.model.KetchupUSPizza;
import com.devil.designmodel.factory.model.USPizza;

public class KetchupPizzaFactory extends PizzaFactory {

    @Override
    public ChinesePizza createChinesePizza() {
        System.out.println("开始制作中国pizza");
        KetchupChinesePizza pizza = new KetchupChinesePizza();
        pizza.addFlour();
        pizza.addWater();
        pizza.addSeasoning();
        return pizza;
    }

    @Override
    public USPizza createUSPizza() {
        System.out.println("开始制作美国pizza");
        KetchupUSPizza pizza = new KetchupUSPizza();
        pizza.addFlour();
        pizza.addWater();
        pizza.addSeasoning();
        return pizza;
    }

}
