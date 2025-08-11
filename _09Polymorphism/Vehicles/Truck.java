package _09Polymorphism.Vehicles;

public class Truck extends Vehicle {

    private static final double SUMMER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    public boolean drive(double distance) {
        double needFuel = distance * (fuelConsumption + SUMMER_CONSUMPTION);

        if (needFuel <= fuelQuantity) {
            fuelQuantity -= needFuel;
            return true;
        }
        return false;
    }

    @Override
    public void refuel(double liters) {
        fuelQuantity += liters * 0.95;
    }
}
