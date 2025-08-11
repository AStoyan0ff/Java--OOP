package handball.entities.equipment;

public abstract class BaseEquipment implements Equipment {

    private int protection;
    private double price;

    public BaseEquipment(double price, int protection) {

        this.price = price;
        this.protection = protection;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
