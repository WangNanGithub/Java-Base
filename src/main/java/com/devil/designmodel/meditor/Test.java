package com.devil.designmodel.meditor;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new HouseMediator();
        House house1 = new House(mediator, "海边别墅");
        House house2 = new House(mediator, "山中别墅");
        Lodger lodger1 = new Lodger(mediator, "张三", 500);
        Lodger lodger2 = new Lodger(mediator, "李四", 1000);
        
        house1.changePrice(500);
    }
}
