package _07InterfacesAbstraction.BorderControl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] data = input.split("\\s+");
            Identifiable identifiable;

            if (data.length == 3) {

                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                identifiable = new Citizen(name, age, id);
            }
            else {
                String model = data[0];
                String id = data[1];

                identifiable = new Robot(model, id);
            }

            identifiableList.add(identifiable);
        }

        String fakeFix = scanner.nextLine();

        for (Identifiable i : identifiableList) {

            if (i.getId().endsWith(fakeFix)) {
                System.out.println(i.getId());
            }
        }
    }
}
