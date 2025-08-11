package _07InterfacesAbstraction.CarShopExtended;

public class Seat extends CarImpl implements Sellable{

    private final Double price;

    public Seat(String model, String color, Integer horsePower, String country, Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {

        return super.toString() + System.lineSeparator() +
                String.format("%s sells for %.6f", getModel(), price);
    }
}
