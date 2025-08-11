package _01WorkingAbstraction.HotelReservation;

public class PriceCalculator {

    private double daysPrice;
    private int daysCnt;
    private Season season;
    private DiscountType discountType;

    public PriceCalculator(double daysPrice, int daysCnt, Season season, DiscountType discountType) {

        this.daysPrice = daysPrice;
        this.daysCnt = daysCnt;
        this.season = season;
        this.discountType = discountType;
    }

    public double calculate() {

        double finalPrice = daysPrice * daysCnt;
        finalPrice *= season.getMultiplier();
        finalPrice -= finalPrice * discountType.getDiscount();
        return finalPrice;
    }
}
