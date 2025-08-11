package _09Polymorphism.Animals;

public class Dog extends Animal {

    public Dog(String name, String favoriteFood) {

        super.name = name;
        super.favouriteFood = favoriteFood;
    }

    @Override
    public String explainSelf() {

        StringBuilder buff = new StringBuilder();

        buff.append("I am Oscar and my favourite food is Meat")
            .append(System.lineSeparator())
            .append("DJAAF");

        return buff.toString();
    }
}
