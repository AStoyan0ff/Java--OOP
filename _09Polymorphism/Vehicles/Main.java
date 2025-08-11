package _09Polymorphism.Vehicles;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("##.##");
        String[] carInfo = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(carInfo[1]),
                              Double.parseDouble(carInfo[2]));


        String[] truckInfo = scanner.nextLine().split("\\s+");

        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]),
                                  Double.parseDouble(truckInfo[2]));

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {
            String[] cmd = scanner.nextLine().split("\\s+");

            String action = cmd[0];
            String type = cmd[1];
            double value = Double.parseDouble(cmd[2]);

            Vehicle vehicle = type.equals("Car") ? car : truck;

            if (action.equals("Drive")) {
                boolean bFist = vehicle.drive(value);

                if (bFist) {
                    System.out.printf("%s travelled %s km%n",
                            type, df.format(value)
                                    .replaceAll("\\.?0+$", ""));

                }
                else {
                    System.out.printf("%s needs refueling%n", type);
                }
            } else if (action.equals("Refuel")) {
                vehicle.refuel(value);
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }
}
