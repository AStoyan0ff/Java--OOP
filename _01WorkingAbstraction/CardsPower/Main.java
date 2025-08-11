package _01WorkingAbstraction.CardsPower;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankIn = scanner.nextLine();
        String suitIn = scanner.nextLine();

        CardRank r = CardRank.valueOf(rankIn);
        CardSuit s = CardSuit.valueOf(suitIn);

        Card c = new Card(r, s); // създаваме картата
        System.out.println(c);
    }
}
