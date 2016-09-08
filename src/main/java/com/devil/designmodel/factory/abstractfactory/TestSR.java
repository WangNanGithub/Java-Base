package com.devil.designmodel.factory.abstractfactory;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.USPizza;

public class TestSR {
    public static void main(String[] args) throws Exception {
        USPizza pizza = SRFactory.createUSPizza("com.devil.designmodel.factory.model.KetchupUSPizza");
        ChinesePizza pizza2 = SRFactory.createChinesePizza("com.devil.designmodel.factory.model.SaladChinesePizza");
    }
}
