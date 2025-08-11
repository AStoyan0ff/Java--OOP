package _09Polymorphism.Animals;

public class Main {
    public static void main(String[] args) {

        Animal dog = new Dog("Oskar", "Wiskas");
        Animal cat = new Cat("Rochy", "Meet");

        System.out.println(dog.explainSelf());
        System.out.println(cat.explainSelf());
    }
}
