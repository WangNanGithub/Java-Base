package com.devil.designmodel.meditor;

import java.util.ArrayList;
import java.util.List;

/**
 * 房子中介
 */
public class HouseMediator extends Mediator {
    private List<Colleague> houses = new ArrayList<Colleague>();
    private List<Colleague> lodgers = new ArrayList<Colleague>();

    @Override
    public void changed(Colleague c) {
        if (c instanceof House) {
            for (Colleague lodger : lodgers) {
                message((House) c, (Lodger) lodger);
            }
        }
        if (c instanceof Lodger) {
            for (Colleague house : houses) {
                House house2 = (House) house;
                Lodger lodger = (Lodger) c;
                if (house2.getName().equals(lodger.getHouse())) {
                    rentHouse((House) house, (Lodger) c);
                }
            }
        }
    }

    @Override
    public void addColleague(Colleague c) {
        if (c instanceof House) {
            houses.add(c);
        }
        if (c instanceof Lodger) {
            lodgers.add(c);
        }
    }

    public void message(House house, Lodger lodger) {
        lodger.message(house.getName(), house.getPrice());
    }

    public void rentHouse(House house, Lodger lodger) {
        house.rentHouse(lodger.getName());
    }

}
