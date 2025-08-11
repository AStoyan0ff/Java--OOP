package _09Polymorphism.Animals;

public class Cat extends Animal {

    public Cat(String name, String favoriteFood) {

        super.name = name;
        super.favouriteFood = favoriteFood;
    }

    @Override
    public String explainSelf() {
        StringBuilder buff = new StringBuilder();

        buff.append("I am ")
                .append(super.name)
                .append(" and my favorite food is ")
                .append(super.favouriteFood)
                .append(System.lineSeparator())
                .append("MEEOW");

        return buff.toString();
    }

}