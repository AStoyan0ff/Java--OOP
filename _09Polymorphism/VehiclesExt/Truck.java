package _09Polymorphism.VehiclesExt;

public class Truck extends Vehicle {
    private static final double EXTRA_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + EXTRA_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refuel(double liters) {

        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        double adjustedLiters = liters * 0.95;

        if (getFuelQuantity() + adjustedLiters > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        setFuelQuantity(getFuelQuantity() + adjustedLiters);
    }
}
