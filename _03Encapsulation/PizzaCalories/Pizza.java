package _03Encapsulation.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    private void setNumberOfToppings(int numberOfToppings) {

        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_RANGE);
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException(ExceptionMessages.PIZZA_NAME);
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() >= this.numberOfToppings) {
            throw new IllegalArgumentException(ExceptionMessages.NUMBER_RANGE);
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalCalories = dough.calculateCalories();

        for (Topping topping : toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }
}
