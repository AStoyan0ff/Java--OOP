package _05Inheritance.Restaurant;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Coffee coffee = new Coffee("Espresso", 80);
        Cake cake = new Cake("Chocolate cake");
        Salmon salmon = new Salmon("Grilled Salmon", BigDecimal.valueOf(12.50));
        Soup soup = new Soup("Chicken soup", BigDecimal.valueOf(4.99), 300);

        System.out.println("Coffee: " + coffee.getName() + ", Caffeine: " + coffee.getCaffeine() + "mg");
        System.out.println("Cake: " + cake.getName() + ", Calories: " + cake.getCalories());
        System.out.println("Salmon: " + salmon.getName() + ", Grams: " + salmon.getGrams());
        System.out.println("Soup: " + soup.getName() + ", Price: " + soup.getPrice());
    }
}
