package _05Inheritance.Zoo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lizard lizard = new Lizard("DonAngel");
        Snake snake = new Snake("Ramadan");
        Bear bear = new Bear("Andrey");
        Gorilla gorilla = new Gorilla("Georgi");

        System.out.println(lizard.getName());
        System.out.println(snake.getName());
        System.out.println(bear.getName());
        System.out.println(gorilla.getName());

    }
}
