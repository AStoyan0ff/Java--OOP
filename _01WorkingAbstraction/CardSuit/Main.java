package _01WorkingAbstraction.CardSuit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("Card Suits")) {
            System.out.println("Card Suits:");
        }

        for (CardSuit card : CardSuit.values()) {

            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    card.ordinal(), card.name());
        }
    }
}
