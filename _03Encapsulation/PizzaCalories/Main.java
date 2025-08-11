package _03Encapsulation.PizzaCalories;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");
        String pizzaName = inputData[1];
        int toppingCnt = Integer.parseInt(inputData[2]);

        Pizza pizza = new Pizza(pizzaName, toppingCnt);

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double doughWeight = Double.parseDouble(doughData[3]);

        Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
        pizza.setDough(dough);

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {
            String[] toppingData = input.split("\\s+");

            String toppingType = toppingData[1];
            double toppingWeight = Double.parseDouble(toppingData[2]);

            Topping topping = new Topping(toppingType, toppingWeight);
            pizza.addTopping(topping);
        }

        System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
    }
}
