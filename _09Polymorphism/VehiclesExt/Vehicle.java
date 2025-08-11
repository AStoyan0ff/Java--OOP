package _09Polymorphism.VehiclesExt;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setTankCapacity(tankCapacity);

        if (fuelQuantity > tankCapacity) {
            this.fuelQuantity = 0;
        }
        else {
            this.fuelQuantity = fuelQuantity;
        }

        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double neededFuel = distance * getConsumption();

        if (neededFuel <= getFuelQuantity()) {

            setFuelQuantity(getFuelQuantity() - neededFuel);
            return String.format("%s travelled %.0f km", getClass().getSimpleName(), distance);
        }
        else {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
    }

    public void refuel(double liters) {
        if (liters <= 0) {

            System.out.println("Fuel must be a positive number");
            return;
        }

        if (getFuelQuantity() + liters > getTankCapacity()) {

            System.out.println("Cannot fit fuel in tank");
            return;
        }

        setFuelQuantity(getFuelQuantity() + liters);
    }


    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumption() {
        return fuelConsumption;
    }

    public void setConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}