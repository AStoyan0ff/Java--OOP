package _03Encapsulation.PizzaCalories;
import java.util.Map;

public class Dough {

    private static final Map<String, Double> FLOUR_MODIFIERS =  Map.of(
                    "White", 1.5,
                    "Wholegrain", 1.0
    );

    private static final Map<String, Double> TECHNIQUE_MODIFIERS = Map.of(
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0
    );

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {

        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {

        if (!FLOUR_MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TYPE);
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {

        if (!TECHNIQUE_MODIFIERS.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TYPE);
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {

        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(ExceptionMessages.DOUGH_RANGE);
        }
        this.weight = weight;
    }

    public double calculateCalories() {

        double baseCalories = 2 * weight;
        return baseCalories * FLOUR_MODIFIERS.get(flourType) * TECHNIQUE_MODIFIERS.get(bakingTechnique);
    }
}
