package _07InterfacesAbstraction.CarShopExtended;

public class Audi extends CarImpl implements Rentable {
    private final Integer minRentDay;
    private final Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String country,
                Integer minRentDay, Double pricePerDay) {

        super(model, color, horsePower, country);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {

        return super.toString() + System.lineSeparator() +
                String.format("Minimum rental period of %d days. Price per day %.6f",
                        minRentDay, pricePerDay);
    }
}
