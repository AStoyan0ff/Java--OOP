package _01WorkingAbstraction.GreedyTimes;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagCapacity);

        for(int pos = 0; pos < input.length; pos += 2) {

            String itName = input[pos];
            long qty = Long.parseLong(input[pos + 1]);

            TreasureItem it = new TreasureItem(itName, qty);
            bag.add(it);
        }

        bag.print();
    }
}
