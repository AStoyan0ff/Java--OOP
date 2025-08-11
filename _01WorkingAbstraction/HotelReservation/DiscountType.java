package _01WorkingAbstraction.HotelReservation;

public enum DiscountType {

    VIP(0.20),
    SecondVisit(0.10),
    None(0.00);

    private final double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
