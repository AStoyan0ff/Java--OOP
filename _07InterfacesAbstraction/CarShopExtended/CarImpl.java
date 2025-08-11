package _07InterfacesAbstraction.CarShopExtended;

public abstract class CarImpl implements Car {

    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String country;

    public CarImpl(String model, String color, Integer horsePower, String country) {

        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return country;
    }

    @Override
    public String toString() {
        return String.format(
                "This is %s produced in %s and have %d tires",
                model, country, TIRES);
    }
}
