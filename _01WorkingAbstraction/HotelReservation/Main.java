package _01WorkingAbstraction.HotelReservation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        double daysPrice = Double.parseDouble(data[0]);
        int daysCnt = Integer.parseInt(data[1]);

        Season season = Season.valueOf(data[2]);
        DiscountType discountType = DiscountType.valueOf(data[3]);

        PriceCalculator calculator = new PriceCalculator(daysPrice, daysCnt, season, discountType);
        double finalPrice = calculator.calculate();

        System.out.printf("%.2f%n", finalPrice);
    }
}
