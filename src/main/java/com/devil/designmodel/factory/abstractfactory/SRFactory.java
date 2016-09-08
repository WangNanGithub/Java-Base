package com.devil.designmodel.factory.abstractfactory;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.USPizza;

public class SRFactory {

    public static ChinesePizza createChinesePizza(String name) throws Exception {
        System.out.println("开始制作中国pizza");
        ChinesePizza pizza = (ChinesePizza) Class.forName(name).newInstance();
        pizza.addFlour();
        pizza.addWater();
        pizza.addSeasoning();
        return pizza;
    }

    public static USPizza createUSPizza(String name) throws Exception {
        System.out.println("开始制作美国pizza");
        USPizza pizza = (USPizza) Class.forName(name).newInstance();
        pizza.addFlour();
        pizza.addWater();
        pizza.addSeasoning();
        return pizza;
    }

}
