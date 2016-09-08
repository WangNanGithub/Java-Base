package com.devil.designmodel.factory.abstractfactory;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.USPizza;

public class TestMain {
    public static void main(String[] args) {
        PizzaFactory kf = new KetchupPizzaFactory();
        ChinesePizza pizza1 = kf.createChinesePizza();

        PizzaFactory sf = new SaladPizzaFactory();
        USPizza pizza2 = sf.createUSPizza();
    }
}
