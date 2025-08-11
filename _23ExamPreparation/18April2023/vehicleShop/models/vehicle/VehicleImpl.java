package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle {

    private String name;
    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {

        setName(name);
        setStrengthRequired(strengthRequired);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    public void setName(String name) {

        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrengthRequired(int strengthRequired) {

        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }


    public boolean reached() {
        return strengthRequired == 0;
    }


    public void making() {
        this.strengthRequired = Math.max(0, this.strengthRequired - 5);

        /*if (this.strengthRequired - 5 < 0) {
            this.strengthRequired = 0;
        }
        else {
            this.strengthRequired -= 5;
        }*/
    }
}
