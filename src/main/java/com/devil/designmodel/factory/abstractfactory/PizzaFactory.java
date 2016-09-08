package com.devil.designmodel.factory.abstractfactory;

import com.devil.designmodel.factory.model.ChinesePizza;
import com.devil.designmodel.factory.model.USPizza;

public abstract class PizzaFactory {
    public abstract ChinesePizza createChinesePizza();

    public abstract USPizza createUSPizza();
}
