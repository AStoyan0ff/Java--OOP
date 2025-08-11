package _09Polymorphism.VehiclesExt;

public class Bus extends Vehicle {
    private static final double EXTRA_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    public String withPeople(double distance) {
        setConsumption(getConsumption() + EXTRA_CONSUMPTION);

        String result = super.drive(distance);

        setConsumption(getConsumption() - EXTRA_CONSUMPTION);
        return result;
    }

    public String DriveEmpty(double distance) {
        return super.drive(distance);
    }
}

