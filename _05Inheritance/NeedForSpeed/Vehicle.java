package _05Inheritance.NeedForSpeed;

public class Vehicle {

    public static final double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumation;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {

        this.fuel = fuel;
        this.horsePower = horsePower;
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

    public double getFuelConsumption() {
        return this.fuelConsumation;
    }

    public void setFuelConsumption(double fuelConsumation) {
        this.fuelConsumation = fuelConsumation;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void drive(double kilometers) {
        double needFuel = kilometers * getFuelConsumption();

        if (this.getFuel() >= needFuel) {
          this.setFuel(this.getFuel() - needFuel);
        }
    }
}
