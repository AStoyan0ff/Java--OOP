package _09Polymorphism.Vehicles;

public class Car extends Vehicle {

    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
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
        fuelQuantity += liters;
    }
}
