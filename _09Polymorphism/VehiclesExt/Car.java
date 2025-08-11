package _09Polymorphism.VehiclesExt;

public class Car extends Vehicle {

    private static final double EXTRA_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + EXTRA_CONSUMPTION, tankCapacity);
    }
}
