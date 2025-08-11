package _11Reflection.BarracksWarsFactory.core;

import _11Reflection.BarracksWarsFactory.factories.UnitFactory;
import _11Reflection.BarracksWarsFactory.factories.UnitFactoryImpl;
import _11Reflection.BarracksWarsFactory.repositories.Repository;
import _11Reflection.BarracksWarsFactory.repositories.RepositoryImpl;
import _11Reflection.BarracksWarsFactory.units.Unit;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Repository repository = new RepositoryImpl();
        UnitFactory unitFactory = new UnitFactoryImpl();

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("fight")) {
                break;
            }

            String[] parts = input.split("\\s+");
            String command = parts[0];

            switch (command) {

                case "add":
                    String unitType = parts[1];

                    try {
                        Unit unit = unitFactory.createUnit(unitType);
                        repository.addUnit(unitType);
                        System.out.println(unitType + " added!");
                    }
                    catch (Exception e) {
                        System.out.println("Error creating unit: " + e.getMessage());
                    }
                    break;

                case "report":

                    repository.getStatistics()
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
                    break;

                default:

                    System.out.println("Unknown command.");
                    break;
            }
        }
    }
}
