package _07InterfacesAbstraction.Telephony;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numberList = Arrays.asList(scanner.nextLine().split("\\s+"));
        List<String> urlsList =  Arrays.asList(scanner.nextLine().split("\\s+"));

        Smartphone smartphone = new Smartphone(numberList, urlsList);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
