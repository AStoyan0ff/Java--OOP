package _07InterfacesAbstraction.FoodShortage;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Buyer> peopleMap = new HashMap<>();
        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length == 4) {

                String id = data[2];
                String birthDate = data[3];
                peopleMap.put(name, new Citizen(name, age, id, birthDate));
            }
            else if (data.length == 3) {

                String group = data[2];
                peopleMap.put(name, new Rebel(name, age, group));
            }
        }

        String buyName;
        while (!(buyName = scanner.nextLine()).equals("End")) {
            Buyer buyer = peopleMap.get(buyName);

            if (buyer != null) {
                buyer.buyFood();
            }
        }

        int totalFood = peopleMap
                .values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(totalFood);
    }
}
