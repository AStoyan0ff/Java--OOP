package _09Polymorphism.VehiclesExt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = readInfo(scanner);
        Vehicle truck = readInfo(scanner);
        Bus bus = (Bus) readInfo(scanner);

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {

            String[] data = scanner.nextLine().split("\\s+");
            String cmd = data[0];
            String type = data[1];

            switch (cmd) {

                case "Drive" -> {
                    double distance = Double.parseDouble(data[2]);

                    switch (type) {

                        case "Car" -> System.out.println(car.drive(distance));
                        case "Truck" -> System.out.println(truck.drive(distance));
                        case "Bus" -> System.out.println(bus.withPeople(distance));
                    }
                }
                case "DriveEmpty" -> {

                    double noDistance = Double.parseDouble(data[2]);
                    System.out.println(bus.DriveEmpty(noDistance));
                }
                case "Refuel" -> {
                    double liters = Double.parseDouble(data[2]);

                    switch (type) {

                        case "Car" -> car.refuel(liters);
                        case "Truck" -> truck.refuel(liters);
                        case "Bus" -> bus.refuel(liters);
                    }
                }
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }

    private static Vehicle readInfo(Scanner scanner) {
        String[] data = scanner.nextLine().split("\\s+");

        String type = data[0];
        double fuelQuantity = Double.parseDouble(data[1]);
        double consumption = Double.parseDouble(data[2]);
        double tankCapacity = Double.parseDouble(data[3]);

        return switch (type) {

            case "Car" -> new Car(fuelQuantity, consumption, tankCapacity);
            case "Truck" -> new Truck(fuelQuantity, consumption, tankCapacity);
            case "Bus" -> new Bus(fuelQuantity, consumption, tankCapacity);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        };
    }
}
