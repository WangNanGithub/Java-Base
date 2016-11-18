package com.devil.designmodel.meditor;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new HouseMediator();
        House house1 = new House1(mediator);
        House house2 = new House2(mediator);
        Lodger lodger1 = new Lodger1(mediator);
        Lodger lodger2 = new Lodger2(mediator);
        
        
    }
}
