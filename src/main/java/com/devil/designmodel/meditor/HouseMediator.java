package com.devil.designmodel.meditor;

import java.util.ArrayList;
import java.util.List;

/**
 * 房子中介
 */
public class HouseMediator extends Mediator {
    private List<Lodger> lodgers = new ArrayList<Lodger>();

    @Override
    public void changed(Colleague c) {
        for (Colleague colleague : lodgers) {
            Lodger lodger = (Lodger) colleague;
            House house = (House) c;
            lodger.message(c.getName(), house.getPrice());
        }
    }
    
    
}
