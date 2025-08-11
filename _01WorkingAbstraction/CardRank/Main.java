package _01WorkingAbstraction.CardRank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("Card Ranks")) {
            System.out.println("Card Ranks:");

            for(CardRank card : CardRank.values()) {

                System.out.printf("Ordinal value: %d; Name value: %s%n",
                        card.ordinal(), card.name());
            }
        }
    }
}
